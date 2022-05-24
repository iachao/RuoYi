package com.ruoyi.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.order.domain.CustomerFloorData;

/**
 * 客户地板测量数据Mapper接口
 *
 * @author Chaos
 * @date 2022-03-08
 */
public interface CustomerFloorDataMapper extends BaseMapper<CustomerFloorData> {

    int deleteByCustomerId(Long customerId);
}
