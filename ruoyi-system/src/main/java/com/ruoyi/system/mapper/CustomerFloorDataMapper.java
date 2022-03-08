package com.ruoyi.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.system.domain.CustomerFloorData;

import java.util.List;

/**
 * 客户地板测量数据Mapper接口
 *
 * @author Chaos
 * @date 2022-03-08
 */
public interface CustomerFloorDataMapper extends BaseMapper<CustomerFloorData> {
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
     * 删除客户地板测量数据
     *
     * @param id 客户地板测量数据主键
     * @return 结果
     */
    int deleteCustomerFloorDataById(Long id);

    /**
     * 批量删除客户地板测量数据
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteCustomerFloorDataByIds(String[] ids);

    int deleteByCustomerId(Long customerId);
}
