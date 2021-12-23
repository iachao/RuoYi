package com.ruoyi.system.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CustomerOrderMapper;
import com.ruoyi.system.domain.CustomerOrder;
import com.ruoyi.system.service.ICustomerOrderService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户Service业务层处理
 * 
 * @author Chaos
 * @date 2021-12-18
 */
@Service
public class CustomerOrderServiceImpl extends ServiceImpl<CustomerOrderMapper,CustomerOrder> implements ICustomerOrderService
{
    @Autowired
    private CustomerOrderMapper customerOrderMapper;

    /**
     * 查询客户
     *
     * @param id 客户主键
     * @return 客户
     */
    @Override
    public CustomerOrder selectCustomerOrderById(Long id)
    {
        CustomerOrder customerOrder = customerOrderMapper.selectById(id);
        return customerOrderMapper.selectCustomerOrderById(id);
    }

    /**
     * 查询客户列表
     *
     * @param customerOrder 客户
     * @return 客户
     */
    @Override
    public List<CustomerOrder> selectCustomerOrderList(CustomerOrder customerOrder)
    {
        return customerOrderMapper.selectCustomerOrderList(customerOrder);
    }

    /**
     * 新增客户
     *
     * @param customerOrder 客户
     * @return 结果
     */
    @Override
    public int insertCustomerOrder(CustomerOrder customerOrder)
    {
        customerOrder.setCreateTime(DateUtils.getNowDate());
        return customerOrderMapper.insertCustomerOrder(customerOrder);
    }

    /**
     * 修改客户
     *
     * @param customerOrder 客户
     * @return 结果
     */
    @Override
    public int updateCustomerOrder(CustomerOrder customerOrder)
    {
        customerOrder.setUpdateTime(DateUtils.getNowDate());
        return customerOrderMapper.updateCustomerOrder(customerOrder);
    }

    /**
     * 批量删除客户
     *
     * @param ids 需要删除的客户主键
     * @return 结果
     */
    @Override
    public int deleteCustomerOrderByIds(String ids)
    {
        return customerOrderMapper.deleteCustomerOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户信息
     *
     * @param id 客户主键
     * @return 结果
     */
    @Override
    public int deleteCustomerOrderById(Long id)
    {
        return customerOrderMapper.deleteCustomerOrderById(id);
    }
}
