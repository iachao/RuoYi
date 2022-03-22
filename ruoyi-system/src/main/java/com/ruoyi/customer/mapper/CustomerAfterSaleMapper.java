package com.ruoyi.customer.mapper;

import java.util.List;
import com.ruoyi.customer.domain.CustomerAfterSale;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 客户售后服务Mapper接口
 * 
 * @author Chaos
 * @date 2022-03-22
 */
public interface CustomerAfterSaleMapper extends BaseMapper<CustomerAfterSale>
{
    /**
     * 查询客户售后服务
     * 
     * @param id 客户售后服务主键
     * @return 客户售后服务
     */
        CustomerAfterSale selectCustomerAfterSaleById(Long id);

    /**
     * 查询客户售后服务列表
     * 
     * @param customerAfterSale 客户售后服务
     * @return 客户售后服务集合
     */
    List<CustomerAfterSale> selectCustomerAfterSaleList(CustomerAfterSale customerAfterSale);

    /**
     * 新增客户售后服务
     * 
     * @param customerAfterSale 客户售后服务
     * @return 结果
     */
    int insertCustomerAfterSale(CustomerAfterSale customerAfterSale);

    /**
     * 修改客户售后服务
     * 
     * @param customerAfterSale 客户售后服务
     * @return 结果
     */
    int updateCustomerAfterSale(CustomerAfterSale customerAfterSale);

    /**
     * 删除客户售后服务
     * 
     * @param id 客户售后服务主键
     * @return 结果
     */
    int deleteCustomerAfterSaleById(Long id);

    /**
     * 批量删除客户售后服务
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteCustomerAfterSaleByIds(String[] ids);
}
