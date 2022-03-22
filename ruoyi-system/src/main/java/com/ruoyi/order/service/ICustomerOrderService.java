package com.ruoyi.order.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.order.domain.CustomerOrder;

/**
 * 客户Service接口
 * 
 * @author Chaos
 * @date 2021-12-18
 */
public interface ICustomerOrderService extends IService<CustomerOrder>
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
     * 批量删除客户
     *
     * @param ids 需要删除的客户主键集合
     * @return 结果
     */
    int deleteCustomerOrderByIds(String ids);

    /**
     * 删除客户信息
     *
     * @param id 客户主键
     * @return 结果
     */
    int deleteCustomerOrderById(Long id);

    /**
     * 根据 手机号、姓名、地址 获取客户信息
     * @param keyword
     * @return
     */
    List<CustomerOrder> selectByInfo(String keyword);
}
