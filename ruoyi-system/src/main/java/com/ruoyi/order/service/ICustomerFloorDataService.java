package com.ruoyi.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.order.domain.CustomerFloorData;

import java.util.List;

/**
 * 客户地板测量数据Service接口
 *
 * @author Chaos
 * @date 2022-03-08
 */
public interface ICustomerFloorDataService extends IService<CustomerFloorData>
{
    /**
     * 查询客户地板测量数据
     *
     * @param id 客户地板测量数据主键
     * @return 客户地板测量数据
     */
    CustomerFloorData selectCustomerFloorDataById(Long id);

    /**
     * 查询客户地板测量数据列表
     *
     * @param customerFloorData 客户地板测量数据
     * @return 客户地板测量数据集合
     */
    List<CustomerFloorData> selectCustomerFloorDataList(CustomerFloorData customerFloorData);

    /**
     * 新增客户地板测量数据
     *
     * @param customerFloorData 客户地板测量数据
     * @return 结果
     */
    int insertCustomerFloorData(CustomerFloorData customerFloorData);

    /**
     * 修改客户地板测量数据
     *
     * @param customerFloorData 客户地板测量数据
     * @return 结果
     */
    int updateCustomerFloorData(CustomerFloorData customerFloorData);

    /**
     * 批量删除客户地板测量数据
     *
     * @param ids 需要删除的客户地板测量数据主键集合
     * @return 结果
     */
    int deleteCustomerFloorDataByIds(String ids);

    /**
     * 删除客户地板测量数据信息
     *
     * @param id 客户地板测量数据主键
     * @return 结果
     */
    int deleteCustomerFloorDataById(Long id);


    /**
     * 删除客户地板测量数据信息根据客户ID
     *
     * @param customerId 客户ID
     * @return 结果
     */
    int deleteByCustomerId(Long customerId);

}
