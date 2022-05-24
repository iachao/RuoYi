package com.ruoyi.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.order.domain.CustomerFloorData;
import com.ruoyi.order.mapper.CustomerFloorDataMapper;
import com.ruoyi.order.service.ICustomerFloorDataService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 客户地板测量数据Service业务层处理
 *
 * @author Chaos
 * @date 2022-03-08
 */
@Service
public class CustomerFloorDataServiceImpl extends ServiceImpl<CustomerFloorDataMapper, CustomerFloorData> implements ICustomerFloorDataService
{

    /**
     * 查询客户地板测量数据
     *
     * @param id 客户地板测量数据主键
     * @return 客户地板测量数据
     */
    @Override
    public CustomerFloorData selectCustomerFloorDataById(Long id)
    {
        return baseMapper.selectById(id);
    }

    /**
     * 查询客户地板测量数据列表
     *
     * @param customerFloorData 客户地板测量数据
     * @return 客户地板测量数据
     */
    @Override
    public List<CustomerFloorData> selectCustomerFloorDataList(CustomerFloorData customerFloorData)
    {
        QueryWrapper<CustomerFloorData> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.setEntity(customerFloorData);
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * 新增客户地板测量数据
     *
     * @param customerFloorData 客户地板测量数据
     * @return 结果
     */
    @Override
    public int insertCustomerFloorData(CustomerFloorData customerFloorData)
    {
        customerFloorData.setCreateTime(DateUtils.getNowDate());
        return baseMapper.insert(customerFloorData);
    }

    /**
     * 修改客户地板测量数据
     *
     * @param customerFloorData 客户地板测量数据
     * @return 结果
     */
    @Override
    public int updateCustomerFloorData(CustomerFloorData customerFloorData)
    {
        customerFloorData.setUpdateTime(DateUtils.getNowDate());
        return baseMapper.updateById(customerFloorData);
    }

    /**
     * 批量删除客户地板测量数据
     *
     * @param ids 需要删除的客户地板测量数据主键
     * @return 结果
     */
    @Override
    public int deleteCustomerFloorDataByIds(String ids)
    {
        return baseMapper.deleteBatchIds(Arrays.asList(Convert.toIntArray(ids)));
    }

    /**
     * 删除客户地板测量数据信息
     *
     * @param id 客户地板测量数据主键
     * @return 结果
     */
    @Override
    public int deleteCustomerFloorDataById(Long id)
    {
        return baseMapper.deleteById(id);
    }

    @Override
    public int deleteByCustomerId(Long customerId) {
        return baseMapper.deleteByCustomerId(customerId);
    }
}