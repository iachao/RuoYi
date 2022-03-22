package com.ruoyi.web.controller.order;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.order.domain.CustomerFloorData;
import com.ruoyi.order.model.FloorCalcParam;
import com.ruoyi.order.model.FloorCalcResult;
import com.ruoyi.order.model.FloorParam;
import com.ruoyi.order.req.FloorCalcReq;
import com.ruoyi.order.resp.FloorCalcResp;
import com.ruoyi.order.service.ICustomerFloorDataService;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 地板计算Controller
 *
 * @author Chaos
 * @date 2022-01-11
 */
@Controller
@RequestMapping("order/floor/calc")
public class FloorCalcController extends BaseController {
    private final String prefix = "order/floor/calc";

    @Autowired
    private ICustomerFloorDataService customerFloorDataService;

    @GetMapping()
    public String calc() {
        return prefix + "/calc";
    }

    @PostMapping("/calcFloor")
    @ResponseBody
    public AjaxResult calcFloor(@RequestBody FloorCalcReq req) {
        // 验证数据正确性
        String floorSpec = req.getFloorSpec();
        String[] split = floorSpec.split("\\*");
        if (split.length != 4) {
            return AjaxResult.error("地板规格参数错误,必须包含 长*宽*厚度*片数 !");
        }
        // 地板规格参数
        FloorParam floorParam = new FloorParam();
        floorParam.setFloorLength(Convert.toBigDecimal(split[0]));
        floorParam.setFloorWidth(Convert.toBigDecimal(split[1]));
        floorParam.setFloorThickness(Convert.toBigDecimal(split[2]));
        floorParam.setFloorBlockPerBox(Convert.toBigDecimal(StringUtils.deleteAny(split[3],"Pp")));

        if(null == floorParam.getFloorLength() || null == floorParam.getFloorWidth()
                || null == floorParam.getFloorThickness() || null == floorParam.getFloorBlockPerBox()
                || floorParam.getFloorLength().compareTo(BigDecimal.ZERO) == 0 || floorParam.getFloorWidth().compareTo(BigDecimal.ZERO) == 0
                || floorParam.getFloorThickness().compareTo(BigDecimal.ZERO) == 0 || floorParam.getFloorBlockPerBox().compareTo(BigDecimal.ZERO) == 0
        ){
            return AjaxResult.error("地板规格参数错误,必须包含 长*宽*厚度*片数 !");
        }
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        BigDecimal totalFloorBlocks = BigDecimal.ZERO;
        BigDecimal totalMeasureAreas = BigDecimal.ZERO;

        List<FloorCalcParam> calcParams = req.getCalcParams();
        for (int i = 0; i < calcParams.size(); i++) {
            FloorCalcParam floorCalcParam1 = calcParams.get(i);
            FloorCalcParam floorCalcParam2 = mapperFactory.getMapperFacade().map(floorCalcParam1,FloorCalcParam.class);

            if(null == floorCalcParam1.getMeasureLength() || null == floorCalcParam1.getMeasureWidth()
                    || floorCalcParam1.getMeasureLength().compareTo(BigDecimal.ZERO) == 0
                    || floorCalcParam1.getMeasureWidth().compareTo(BigDecimal.ZERO) == 0){
                continue;
            }
            // 总测量面积
            totalMeasureAreas = totalMeasureAreas.add(floorCalcParam1.getMeasureLength().multiply(floorCalcParam1.getMeasureWidth()));

            // 优化实际计算木地板块数 长和宽参数
            optimizeFloorCalcParam(floorCalcParam1,floorParam);

            BigDecimal floorBlocks1 = calcFloorBlocks(floorCalcParam1,floorParam);
            swapFloorCalcParam(floorCalcParam2);
            optimizeFloorCalcParam(floorCalcParam2,floorParam);
            BigDecimal floorBlocks2 = calcFloorBlocks(floorCalcParam2,floorParam);
            BigDecimal realUseFloorBlock = floorBlocks1.compareTo(floorBlocks2) == 1 ? floorBlocks2 : floorBlocks1;
            // 该测量面积剩余地板
            if(realUseFloorBlock.compareTo(floorBlocks1) == 0){

            }
            totalFloorBlocks = totalFloorBlocks.add(realUseFloorBlock);

            FloorCalcResult tmp = new FloorCalcResult();
            tmp.setInstallFloorBlock(realUseFloorBlock);
            // 测量面积
            tmp.setMeasureFloorArea(floorCalcParam1.getMeasureLength().multiply(floorCalcParam1.getMeasureWidth()).setScale(4,RoundingMode.HALF_UP));
            // 安装面积和块数
            tmp.setInstallFloorBlock(realUseFloorBlock);
            tmp.setInstallFloorArea(realUseFloorBlock.multiply(floorParam.getFloorLength().multiply(floorParam.getFloorWidth())).setScale(4,RoundingMode.HALF_UP));
            // 发货地板
            BigDecimal sendFloorBox = realUseFloorBlock.divide(floorParam.getFloorBlockPerBox(), 0, RoundingMode.UP);
            tmp.setSendFloorBox(sendFloorBox);
            tmp.setSendFloorBlock(sendFloorBox.multiply(floorParam.getFloorBlockPerBox()));
            // 发货地板面积
            tmp.setSendFloorArea(tmp.getSendFloorBlock().multiply(floorParam.getFloorLength().multiply(floorParam.getFloorWidth())));
            floorCalcParam1.setFloorCalcResult(tmp);
        }

        FloorCalcResult floorCalcResult = new FloorCalcResult();
        for (int i = 0; i < calcParams.size(); i++) {
            FloorCalcParam calcParam = calcParams.get(i);
            if(null == calcParam.getMeasureLength() || null == calcParam.getMeasureWidth()
                    || calcParam.getMeasureLength().compareTo(BigDecimal.ZERO) == 0
                    || calcParam.getMeasureWidth().compareTo(BigDecimal.ZERO) == 0){
                continue;
            }
            FloorCalcResult calcResult = calcParam.getFloorCalcResult();
            floorCalcResult.setMeasureFloorArea(floorCalcResult.getMeasureFloorArea().add(calcResult.getMeasureFloorArea()));
            floorCalcResult.setInstallFloorBlock(floorCalcResult.getInstallFloorBlock().add(calcResult.getInstallFloorBlock()));
        }

        FloorCalcResp floorCalcResp = new FloorCalcResp();
        floorCalcResult.setInstallFloorArea(floorCalcResult.getInstallFloorBlock().multiply(floorParam.getFloorLength().multiply(floorParam.getFloorWidth())));
        // 发货地板箱数
        BigDecimal sendFloorBox = floorCalcResult.getInstallFloorBlock().divide(floorParam.getFloorBlockPerBox(), 0, RoundingMode.UP);
        floorCalcResult.setSendFloorBox(sendFloorBox);
        // 发货地板块数
        floorCalcResult.setSendFloorBlock(sendFloorBox.multiply(floorParam.getFloorBlockPerBox()));
        // 发货地板面积
        floorCalcResult.setSendFloorArea(floorCalcResult.getSendFloorBlock().multiply(floorParam.getFloorLength().multiply(floorParam.getFloorWidth())));
        logger.info("结果: " + JSON.toJSONString(floorCalcResult));
        floorCalcResp.setFloorCalcResult(floorCalcResult);
        floorCalcResp.setFloorCalcParam(calcParams);
        return AjaxResult.success(floorCalcResp);
    }

    /**
     * 保存计算地板数据
     */
    @RequiresPermissions("floor:calc:add")
    @Log(title = "计算地板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody FloorCalcReq req)
    {
        CustomerFloorData cusReq = new CustomerFloorData();
        cusReq.setCustomerId(req.getCustomerId());
        List<CustomerFloorData> result = customerFloorDataService.selectCustomerFloorDataList(cusReq);
        if(!CollectionUtils.isEmpty(result)){
            customerFloorDataService.deleteByCustomerId(req.getCustomerId());
        }
        
        List<CustomerFloorData> list =new ArrayList<>();
        if(!CollectionUtils.isEmpty(req.getCalcParams())){
            for (int i = 0; i < req.getCalcParams().size(); i++) {
                FloorCalcParam floorCalcParam = req.getCalcParams().get(i);
                CustomerFloorData customerFloorData = new CustomerFloorData();
                customerFloorData.setCustomerId(req.getCustomerId());
                customerFloorData.setCustomerInfo(req.getCustomerInfo());
                customerFloorData.setMeasureLength(floorCalcParam.getMeasureLength());
                customerFloorData.setMeasureWidth(floorCalcParam.getMeasureWidth());
                customerFloorData.setCreateBy(getLoginName());

                list.add(customerFloorData);
            }
            return toAjax(customerFloorDataService.saveBatch(list));
        }

        return toAjax(true);
    }


    /**
     * 优化测量参数
     * @param floorCalcParam
     * @param floorParam
     */
    private void optimizeFloorCalcParam(FloorCalcParam floorCalcParam,FloorParam floorParam){
        // 地板离墙最大缝隙 mm
        BigDecimal maxGap = new BigDecimal("10");
        BigDecimal wholeStartLastFloor = floorCalcParam.getMeasureLength().abs().remainder(floorParam.getFloorLength());
        // 横向 最后一块板的尺寸 小于 缝隙 则 舍弃
        if(wholeStartLastFloor.compareTo(BigDecimal.ZERO) == 1 && wholeStartLastFloor.compareTo(maxGap) < 1){
            floorCalcParam.setOptimizeLength(floorCalcParam.getMeasureLength().abs().subtract(wholeStartLastFloor));
        }else{
            floorCalcParam.setOptimizeLength(floorCalcParam.getMeasureLength().abs());
        }
        // 纵向 最后一行的尺寸 小于 缝隙 则 舍弃
        BigDecimal widthRemainder = floorCalcParam.getMeasureWidth().abs().remainder(floorParam.getFloorWidth());
        if(widthRemainder.compareTo(BigDecimal.ZERO) == 1 && widthRemainder.compareTo(maxGap) < 1){
            floorCalcParam.setOptimizeWidth(floorCalcParam.getMeasureWidth().abs().subtract(widthRemainder));
        }else{
            floorCalcParam.setOptimizeWidth(floorCalcParam.getMeasureWidth().abs());
        }
    }

    /**
     * 计算铺地板行数
     * @param calcValue
     * @param floorWidth
     * @return
     */
    private BigDecimal calcFloorRows(BigDecimal calcValue,BigDecimal floorWidth){
        return calcValue.divide(floorWidth,0,RoundingMode.UP);
    }

    /**
     * 计算某测量面积所需地板块数
     * @param floorCalcParam
     * @param floorParam
     * @return
     */
    private BigDecimal calcFloorBlocks(FloorCalcParam floorCalcParam,FloorParam floorParam){
        // 半块板 长度
        BigDecimal halfFloorLength = floorParam.getFloorLength().divide(new BigDecimal(2));
        // 半块板 数量 和 余数
        BigDecimal[] divideAndRemainder = floorCalcParam.getOptimizeLength().divideAndRemainder(halfFloorLength);
        BigDecimal halfLengthCount = divideAndRemainder[0];
        // 余数
        BigDecimal halfStartLastFloor = divideAndRemainder[1];

        // ====关键属性: 每行剩余板长 = (木地板长度/2) - (房间长 % (木地板长度/2) )
        BigDecimal remainderPerRow = BigDecimal.ZERO;
        // 如果余数是0,则每行剩余为 0
        if(halfStartLastFloor.compareTo(BigDecimal.ZERO) != 0){
            remainderPerRow = halfFloorLength.subtract(halfStartLastFloor);
        }
        // ====关键属性: 行数 (即一个面积内地板铺多少行)
        BigDecimal rows = calcFloorRows(floorCalcParam.getOptimizeWidth(),floorParam.getFloorWidth());

        BigDecimal floorBlocks = BigDecimal.ZERO;

        if(floorCalcParam.getMeasureLength().compareTo(BigDecimal.ZERO) == -1 || floorCalcParam.getMeasureWidth().compareTo(BigDecimal.ZERO) == -1){
            floorBlocks = BigDecimal.ZERO.subtract(((floorCalcParam.getOptimizeLength().add(remainderPerRow)).multiply(rows)).divide(floorParam.getFloorLength(),0,RoundingMode.UP));
        }else{
            floorBlocks = ((floorCalcParam.getOptimizeLength().add(remainderPerRow)).multiply(rows)).divide(floorParam.getFloorLength(),0,RoundingMode.UP);
        }
        return floorBlocks;
    }

    /**
     * 交换测量面积长和宽参数
     * @param floorCalcParam
     */
    private void swapFloorCalcParam(FloorCalcParam floorCalcParam){
        long a = floorCalcParam.getMeasureLength().longValue();
        long b = floorCalcParam.getMeasureWidth().longValue();
        if(a == b){
            return;
        }
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        floorCalcParam.setMeasureLength(new BigDecimal(a));
        floorCalcParam.setMeasureWidth(new BigDecimal(b));
    }

    /**
     * 计算某测量面积内剩余地板
     * @param floorCalcParam
     * @param floorParam
     * @param floorStartWay
     * @return
     */
    private List<FloorParam> calcRemainFloor(FloorCalcParam floorCalcParam,FloorParam floorParam,Integer floorStartWay){
        List<FloorParam> remainderFloorTotal = new ArrayList<>();
        BigDecimal rows = calcFloorRows(floorCalcParam.getOptimizeWidth(),floorParam.getFloorWidth());
        // 整块板 余数
        BigDecimal wholeStartLastFloor = floorCalcParam.getOptimizeLength().remainder(floorParam.getFloorLength());
        // 奇数行 计算剩余 板
        if(rows.remainder(new BigDecimal(2)).compareTo(BigDecimal.ZERO) == 1){
            // 半块板 长度
            BigDecimal halfFloorLength = floorParam.getFloorLength().divide(new BigDecimal(2),1,RoundingMode.HALF_UP);
            // 半块板 数量 和 余数
            BigDecimal[] divideAndRemainder = floorCalcParam.getOptimizeLength().divideAndRemainder(halfFloorLength);
            BigDecimal halfLengthCount = divideAndRemainder[0];
            // 剩余木地板数据
            FloorParam remainderFloor = new FloorParam();
            // 半块板 整除
            if(halfLengthCount.compareTo(BigDecimal.ZERO) == 0){
                remainderFloor.setFloorWidth(floorParam.getFloorWidth());
                remainderFloor.setFloorLength(halfFloorLength);
                // 地板起头方式:整块
                if(floorStartWay.equals(1)){
                    remainderFloor.setLeftFloorCut(true);
                }else{
                    remainderFloor.setRightFloorCut(true);
                }
            }else {
                if(wholeStartLastFloor.compareTo(halfFloorLength) == -1){
                    remainderFloor.setFloorWidth(floorParam.getFloorWidth());
                    if(floorStartWay.equals(1)){
                        remainderFloor.setFloorLength(floorParam.getFloorLength().subtract(wholeStartLastFloor));
                        remainderFloor.setLeftFloorCut(true);
                    }else{
                        remainderFloor.setFloorLength(halfFloorLength);
                        remainderFloor.setRightFloorCut(true);
                    }
                }else{
                    remainderFloor.setFloorLength(BigDecimal.ZERO);
                    remainderFloor.setFloorWidth(BigDecimal.ZERO);
                }
            }
            remainderFloorTotal.add(remainderFloor);
        }
        return remainderFloorTotal;
    }
}
