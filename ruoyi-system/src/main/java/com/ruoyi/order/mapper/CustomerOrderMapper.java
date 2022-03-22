package com.ruoyi.order.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.order.domain.CustomerOrder;

/**
 * 客户Mapper接口
 * 
 * @author Chaos
 * @date 2021-12-18
 */
public interface CustomerOrderMapper extends BaseMapper<CustomerOrder>
{
    /**
     * 查询客户
     *
     * @param id 客户主键
     * @return 客户
     */
    CustomerOrder selectCustomerOrderById(Long id);

    /**
     * 查询客户列表
     *
     * @param customerOrder 客户
     * @return 客户集合
     */
    List<CustomerOrder> selectCustomerOrderList(CustomerOrder customerOrder);

    /**
     * 新增客户
     *
     * @param customerOrder 客户
     * @return 结果
     */
    int insertCustomerOrder(CustomerOrder customerOrder);

    /**
     * 修改客户
     *
     * @param customerOrder 客户
     * @return 结果
     */
    int updateCustomerOrder(CustomerOrder customerOrder);

    /**
     * 删除客户
     *
     * @param id 客户主键
     * @return 结果
     */
    int deleteCustomerOrderById(Long id);

    /**
     * 批量删除客户
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteCustomerOrderByIds(String[] ids);

    List<CustomerOrder> selectByInfo(String keyword);
}
