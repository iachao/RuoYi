package com.ruoyi.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.order.domain.CustomerOrder;
import com.ruoyi.order.mapper.CustomerOrderMapper;
import com.ruoyi.order.service.ICustomerOrderService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 客户Service业务层处理
 * 
 * @author Chaos
 * @date 2021-12-18
 */
@Service
public class CustomerOrderServiceImpl extends ServiceImpl<CustomerOrderMapper, CustomerOrder> implements ICustomerOrderService
{

    /**
     * 查询客户
     *
     * @param id 客户主键
     * @return 客户
     */
    @Override
    public CustomerOrder selectCustomerOrderById(Long id)
    {
        return baseMapper.selectById(id);
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
        QueryWrapper<CustomerOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.setEntity(customerOrder);
        return baseMapper.selectList(queryWrapper);
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
        return baseMapper.insert(customerOrder);
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
        return baseMapper.updateById(customerOrder);
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
        return baseMapper.deleteBatchIds(Arrays.asList(Convert.toIntArray(ids)));
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
        return baseMapper.deleteById(id);
    }

    @Override
    public List<CustomerOrder> selectByInfo(String keyword) {
        List<CustomerOrder> list = baseMapper.selectByInfo(keyword);
        return list;
    }
}
