package com.ruoyi.stock.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.purchase.domain.PurchaseFloorOrder;
import com.ruoyi.stock.domain.StockFloor;
import com.ruoyi.stock.mapper.StockFloorMapper;
import com.ruoyi.stock.service.IStockFloorService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

/**
 * 地板库存Service业务层处理
 * 
 * @author Chaos
 * @date 2021-12-18
 */
@Service
public class StockFloorServiceImpl extends ServiceImpl<StockFloorMapper,StockFloor> implements IStockFloorService
{

    /**
     * 查询地板库存
     * 
     * @param id 地板库存主键
     * @return 地板库存
     */
    @Override
    public StockFloor selectStockFloorById(Long id)
    {
        return baseMapper.selectById(id);
    }

    /**
     * 查询地板库存列表
     * 
     * @param stockFloor 地板库存
     * @return 地板库存
     */
    @Override
    public List<StockFloor> selectStockFloorList(StockFloor stockFloor)
    {
        QueryWrapper<StockFloor> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.setEntity(stockFloor);
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * 新增地板库存
     * 
     * @param stockFloor 地板库存
     * @return 结果
     */
    @Override
    public int insertStockFloor(StockFloor stockFloor)
    {
        stockFloor.setFloorArea(this.getStockArea(stockFloor.getFloorSpec(),stockFloor.getStockCount()));
        return baseMapper.insert(stockFloor);
    }

    /**
     * 修改地板库存
     * 
     * @param stockFloor 地板库存
     * @return 结果
     */
    @Override
    public int updateStockFloor(StockFloor stockFloor)
    {
        stockFloor.setFloorArea(this.getStockArea(stockFloor.getFloorSpec(),stockFloor.getStockCount()));
        return baseMapper.updateById(stockFloor);
    }

    /**
     * 批量删除地板库存
     * 
     * @param ids 需要删除的地板库存主键
     * @return 结果
     */
    @Override
    public int deleteStockFloorByIds(String ids)
    {
        return baseMapper.deleteBatchIds(Arrays.asList(Convert.toStrArray(ids)));
    }

    /**
     * 删除地板库存信息
     * 
     * @param id 地板库存主键
     * @return 结果
     */
    @Override
    public int deleteStockFloorById(Long id)
    {
        return baseMapper.deleteById(id);
    }

    /**
     *
     * @param floorSpec 地板规格例如 1221*168*12*10P
     * @param stockCount 地板块数
     * @return
     */
    private BigDecimal getStockArea(String floorSpec,Long stockCount){
        String[] split = floorSpec.split("\\*");
        if(StringUtils.isNotEmpty(split) && split.length == 4) {
            BigDecimal length = new BigDecimal(split[0]);
            BigDecimal width = new BigDecimal(split[1]);
            length = length.divide(new BigDecimal(1000));
            width = width.divide(new BigDecimal(1000));
            BigDecimal stockArea = length.multiply(width).multiply(new BigDecimal(stockCount));
            return stockArea.setScale(4, RoundingMode.HALF_UP);
        }
        return BigDecimal.ZERO;
    }
}
