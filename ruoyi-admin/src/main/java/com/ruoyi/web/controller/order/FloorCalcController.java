package com.ruoyi.web.controller.order;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.system.model.FloorCalcParam;
import com.ruoyi.system.model.FloorCalcResult;
import com.ruoyi.system.model.FloorParam;
import com.ruoyi.system.req.FloorCalcReq;
import com.ruoyi.system.resp.FloorCalcResp;
import org.springframework.stereotype.Controller;
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
        // 地板参数
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
        FloorCalcResp floorCalcResp = new FloorCalcResp();

        BigDecimal totalFloorBlocks = BigDecimal.ZERO;
        BigDecimal totalMeasureAreas = BigDecimal.ZERO;
        List<FloorParam> remainderFloorTotal = new ArrayList<>();
        List<FloorCalcParam> calcParams = req.getCalcParams();
        for (int i = 0; i < calcParams.size(); i++) {
            FloorCalcParam floorCalcParam = calcParams.get(i);
            if(null == floorCalcParam.getMeasureLength() || null == floorCalcParam.getMeasureWidth()
                    || floorCalcParam.getMeasureLength().compareTo(BigDecimal.ZERO) == 0
                    || floorCalcParam.getMeasureWidth().compareTo(BigDecimal.ZERO) == 0){
                continue;
            }
            // 优化实际计算木地板块数 长和宽参数
            optimizeFloorCalcParam(floorCalcParam,floorParam);
            // 总测量面积
            totalMeasureAreas = totalMeasureAreas.add(floorCalcParam.getMeasureLength().multiply(floorCalcParam.getMeasureWidth()));
            // 半块板 长度
            BigDecimal halfFloorLength = floorParam.getFloorLength().divide(new BigDecimal(2));
            // 半块板 数量 和 余数
            BigDecimal[] divideAndRemainder = floorCalcParam.getOptimizeLength().divideAndRemainder(halfFloorLength);
            BigDecimal halfLengthCount = divideAndRemainder[0];
            // 余数
            BigDecimal halfStartLastFloor = divideAndRemainder[1];
            // 整块板 余数
            BigDecimal wholeStartLastFloor = floorCalcParam.getOptimizeLength().remainder(floorParam.getFloorLength());

            // ====关键属性: 行数 (即一个面积内地板铺多少行)
            BigDecimal rows = floorCalcParam.getOptimizeWidth().divide(floorParam.getFloorWidth(), RoundingMode.UP);
            // ====关键属性: 每行剩余板长 = (木地板长度/2) - (房间长 % (木地板长度/2) )
            BigDecimal remainderPerRow = BigDecimal.ZERO;
            // 如果余数是0,则每行剩余为 0
            if(halfStartLastFloor.compareTo(BigDecimal.ZERO) != 0){
                remainderPerRow = halfFloorLength.subtract(halfStartLastFloor);
            }
            // ====该面积内 总块数
            BigDecimal totalBlocks = ((floorCalcParam.getOptimizeLength().add(remainderPerRow)).multiply(rows)).divide(floorParam.getFloorLength(),0,RoundingMode.UP);
            totalFloorBlocks = totalFloorBlocks.add(totalBlocks);
            // 奇数行 计算剩余 板
            if(rows.remainder(new BigDecimal(2)).compareTo(BigDecimal.ZERO) == 1){
                // 剩余木地板数据
                FloorParam remainderFloor = new FloorParam();
                // 半块板 整除
                if(halfLengthCount.compareTo(BigDecimal.ZERO) == 0){
                    remainderFloor.setFloorWidth(floorParam.getFloorWidth());
                    remainderFloor.setFloorLength(halfFloorLength);
                    // 地板起头方式:整块
                    if(req.getFloorStartWay().equals(1)){
                        remainderFloor.setLeftFloorCut(true);
                    }else{
                        remainderFloor.setRightFloorCut(true);
                    }
                }else {
                    if(wholeStartLastFloor.compareTo(halfFloorLength) == -1){
                        remainderFloor.setFloorWidth(floorParam.getFloorWidth());
                        if(req.getFloorStartWay().equals(1)){
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
        }
        FloorCalcResult floorCalcResult = new FloorCalcResult();
        // 测量总面积
        floorCalcResult.setMeasureFloorArea(totalMeasureAreas);
        // 安装总面积 和 块数
        floorCalcResult.setInstallFloorArea(totalFloorBlocks.multiply(floorParam.getFloorLength().multiply(floorParam.getFloorWidth())));
        floorCalcResult.setInstallFloorBlock(totalFloorBlocks);
        // 发货地板箱数
        BigDecimal sendFloorBox = totalFloorBlocks.divide(floorParam.getFloorBlockPerBox(), 0, RoundingMode.UP);
        floorCalcResult.setSendFloorBox(sendFloorBox);
        // 发货地板块数
        floorCalcResult.setSendFloorBlock(sendFloorBox.multiply(floorParam.getFloorBlockPerBox()));
        // 发货地板面积
        floorCalcResult.setSendFloorArea(floorCalcResult.getSendFloorBlock().multiply(floorParam.getFloorLength().multiply(floorParam.getFloorWidth())));
        logger.info("结果: " + JSON.toJSONString(floorCalcResult));
        logger.info("剩余可用板长度: " + JSON.toJSONString(remainderFloorTotal));
        floorCalcResp.setLengthAsLengthResult(floorCalcResult);
        return AjaxResult.success(floorCalcResp);
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
}
