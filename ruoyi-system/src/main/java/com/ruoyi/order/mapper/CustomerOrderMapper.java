package com.ruoyi.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.order.domain.CustomerOrder;

import java.util.List;

/**
 * 客户Mapper接口
 * 
 * @author Chaos
 * @date 2021-12-18
 */
public interface CustomerOrderMapper extends BaseMapper<CustomerOrder>
{
    List<CustomerOrder> selectByInfo(String keyword);
}
