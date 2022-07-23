package com.ruoyi.bid.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.bid.domain.FloorBid;

import java.util.List;

/**
 * 地板报价Mapper接口
 * 
 * @author Chaos
 * @date 2022-03-26
 */
public interface FloorBidMapper extends BaseMapper<FloorBid>
{
    List<FloorBid> selectStaffFloorBidList(FloorBid floorBid);

    List<FloorBid> cooperationFloorBidList(FloorBid floorBid);

    List<FloorBid> directFloorBidList(FloorBid floorBid);
}
