package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.StockFloor;

import java.util.List;

/**
 * 地板库存Mapper接口
 * 
 * @author Chaos
 * @date 2021-12-18
 */
public interface StockFloorMapper 
{
    /**
     * 查询地板库存
     * 
     * @param id 地板库存主键
     * @return 地板库存
     */
    StockFloor selectStockFloorById(Long id);

    /**
     * 查询地板库存列表
     * 
     * @param stockFloor 地板库存
     * @return 地板库存集合
     */
    List<StockFloor> selectStockFloorList(StockFloor stockFloor);

    /**
     * 新增地板库存
     * 
     * @param stockFloor 地板库存
     * @return 结果
     */
    int insertStockFloor(StockFloor stockFloor);

    /**
     * 修改地板库存
     * 
     * @param stockFloor 地板库存
     * @return 结果
     */
    int updateStockFloor(StockFloor stockFloor);

    /**
     * 删除地板库存
     * 
     * @param id 地板库存主键
     * @return 结果
     */
    int deleteStockFloorById(Long id);

    /**
     * 批量删除地板库存
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteStockFloorByIds(String[] ids);
}
