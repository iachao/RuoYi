package com.ruoyi.customer.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.customer.mapper.CustomerAfterSaleMapper;
import com.ruoyi.customer.domain.CustomerAfterSale;
import com.ruoyi.customer.service.ICustomerAfterSaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户售后服务Service业务层处理
 * 
 * @author Chaos
 * @date 2022-03-22
 */
@Service
public class CustomerAfterSaleServiceImpl extends ServiceImpl<CustomerAfterSaleMapper,CustomerAfterSale> implements ICustomerAfterSaleService
{
    @Autowired
    private CustomerAfterSaleMapper customerAfterSaleMapper;

    /**
     * 查询客户售后服务
     * 
     * @param id 客户售后服务主键
     * @return 客户售后服务
     */
    @Override
    public CustomerAfterSale selectCustomerAfterSaleById(Long id)
    {
        return customerAfterSaleMapper.selectCustomerAfterSaleById(id);
    }

    /**
     * 查询客户售后服务列表
     * 
     * @param customerAfterSale 客户售后服务
     * @return 客户售后服务
     */
    @Override
    public List<CustomerAfterSale> selectCustomerAfterSaleList(CustomerAfterSale customerAfterSale)
    {
        return customerAfterSaleMapper.selectCustomerAfterSaleList(customerAfterSale);
    }

    /**
     * 新增客户售后服务
     * 
     * @param customerAfterSale 客户售后服务
     * @return 结果
     */
    @Override
    public int insertCustomerAfterSale(CustomerAfterSale customerAfterSale)
    {
        customerAfterSale.setCreateTime(DateUtils.getNowDate());
        return customerAfterSaleMapper.insertCustomerAfterSale(customerAfterSale);
    }

    /**
     * 修改客户售后服务
     * 
     * @param customerAfterSale 客户售后服务
     * @return 结果
     */
    @Override
    public int updateCustomerAfterSale(CustomerAfterSale customerAfterSale)
    {
        customerAfterSale.setUpdateTime(DateUtils.getNowDate());
        return customerAfterSaleMapper.updateCustomerAfterSale(customerAfterSale);
    }

    /**
     * 批量删除客户售后服务
     * 
     * @param ids 需要删除的客户售后服务主键
     * @return 结果
     */
    @Override
    public int deleteCustomerAfterSaleByIds(String ids)
    {
        return customerAfterSaleMapper.deleteCustomerAfterSaleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户售后服务信息
     * 
     * @param id 客户售后服务主键
     * @return 结果
     */
    @Override
    public int deleteCustomerAfterSaleById(Long id)
    {
        return customerAfterSaleMapper.deleteCustomerAfterSaleById(id);
    }
}
