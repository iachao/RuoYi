package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.CustomerOrder;

/**
 * 客户Service接口
 * 
 * @author Chaos
 * @date 2021-12-18
 */
public interface ICustomerOrderService 
{
    /**
     * 查询客户
     * 
     * @param id 客户主键
     * @return 客户
     */
    public CustomerOrder selectCustomerOrderById(Long id);

    /**
     * 查询客户列表
     * 
     * @param customerOrder 客户
     * @return 客户集合
     */
    public List<CustomerOrder> selectCustomerOrderList(CustomerOrder customerOrder);

    /**
     * 新增客户
     * 
     * @param customerOrder 客户
     * @return 结果
     */
    public int insertCustomerOrder(CustomerOrder customerOrder);

    /**
     * 修改客户
     * 
     * @param customerOrder 客户
     * @return 结果
     */
    public int updateCustomerOrder(CustomerOrder customerOrder);

    /**
     * 批量删除客户
     * 
     * @param ids 需要删除的客户主键集合
     * @return 结果
     */
    public int deleteCustomerOrderByIds(String ids);

    /**
     * 删除客户信息
     * 
     * @param id 客户主键
     * @return 结果
     */
    public int deleteCustomerOrderById(Long id);
}
