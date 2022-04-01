package com.ruoyi.bid.mapper;

import java.util.List;
import com.ruoyi.bid.domain.FloorBid;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 地板报价Mapper接口
 * 
 * @author Chaos
 * @date 2022-03-26
 */
public interface FloorBidMapper extends BaseMapper<FloorBid>
{
    /**
     * 查询地板报价
     * 
     * @param id 地板报价主键
     * @return 地板报价
     */
        FloorBid selectFloorBidById(Long id);

    /**
     * 查询地板报价列表
     * 
     * @param floorBid 地板报价
     * @return 地板报价集合
     */
    List<FloorBid> selectFloorBidList(FloorBid floorBid);

    /**
     * 新增地板报价
     * 
     * @param floorBid 地板报价
     * @return 结果
     */
    int insertFloorBid(FloorBid floorBid);

    /**
     * 修改地板报价
     * 
     * @param floorBid 地板报价
     * @return 结果
     */
    int updateFloorBid(FloorBid floorBid);

    /**
     * 删除地板报价
     * 
     * @param id 地板报价主键
     * @return 结果
     */
    int deleteFloorBidById(Long id);

    /**
     * 批量删除地板报价
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteFloorBidByIds(String[] ids);

    List<FloorBid> selectStaffFloorBidList(FloorBid floorBid);
}
