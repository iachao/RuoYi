package com.ruoyi.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.order.domain.FloorOrder;
import com.ruoyi.order.resp.FloorOrderResp;

import java.util.List;

/**
 * 地板订单Mapper接口
 * 
 * @author Chaos
 * @date 2021-12-25
 */
public interface FloorOrderMapper extends BaseMapper<FloorOrder>
{
    List<FloorOrderResp> selectFloorOrderRespList(FloorOrder floorOrder);
}
