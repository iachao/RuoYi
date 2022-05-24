package com.ruoyi.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.order.domain.FootLineOrder;
import com.ruoyi.order.resp.FootLineOrderResp;

import java.util.List;

/**
 * 踢脚线订单Mapper接口
 * 
 * @author Chaos
 * @date 2022-04-23
 */
public interface FootLineOrderMapper extends BaseMapper<FootLineOrder>
{
    List<FootLineOrderResp> selectFootLineOrderRespList(FootLineOrder footLineOrder);
}
