package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.StockFloor;
import com.ruoyi.system.mapper.StockFloorMapper;
import com.ruoyi.system.service.IStockFloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 地板库存Service业务层处理
 * 
 * @author Chaos
 * @date 2021-12-18
 */
@Service
public class StockFloorServiceImpl implements IStockFloorService
{
    @Autowired
    private StockFloorMapper stockFloorMapper;

    /**
     * 查询地板库存
     * 
     * @param id 地板库存主键
     * @return 地板库存
     */
    @Override
    public StockFloor selectStockFloorById(Long id)
    {
        return stockFloorMapper.selectStockFloorById(id);
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
        return stockFloorMapper.selectStockFloorList(stockFloor);
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
        stockFloor.setCreateTime(DateUtils.getNowDate());
        return stockFloorMapper.insertStockFloor(stockFloor);
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
        stockFloor.setUpdateTime(DateUtils.getNowDate());
        return stockFloorMapper.updateStockFloor(stockFloor);
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
        return stockFloorMapper.deleteStockFloorByIds(Convert.toStrArray(ids));
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
        return stockFloorMapper.deleteStockFloorById(id);
    }
}
