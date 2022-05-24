package com.ruoyi.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.order.domain.FloorOrder;
import com.ruoyi.order.mapper.FloorOrderMapper;
import com.ruoyi.order.resp.FloorOrderResp;
import com.ruoyi.order.service.IFloorOrderService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 地板订单Service业务层处理
 * 
 * @author Chaos
 * @date 2021-12-25
 */
@Service
public class FloorOrderServiceImpl extends ServiceImpl<FloorOrderMapper, FloorOrder> implements IFloorOrderService
{

    /**
     * 查询地板订单
     * 
     * @param id 地板订单主键
     * @return 地板订单
     */
    @Override
    public FloorOrder selectFloorOrderById(Long id)
    {
        return baseMapper.selectById(id);
    }

    /**
     * 查询地板订单列表
     * 
     * @param floorOrder 地板订单
     * @return 地板订单
     */
    @Override
    public List<FloorOrder> selectFloorOrderList(FloorOrder floorOrder)
    {
        QueryWrapper<FloorOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");
        queryWrapper.setEntity(floorOrder);
        return baseMapper.selectList(queryWrapper);
    }

    /**
     * 新增地板订单
     * 
     * @param floorOrder 地板订单
     * @return 结果
     */
    @Override
    public int insertFloorOrder(FloorOrder floorOrder)
    {
        floorOrder.setCreateTime(DateUtils.getNowDate());
        return baseMapper.insert(floorOrder);
    }

    /**
     * 修改地板订单
     * 
     * @param floorOrder 地板订单
     * @return 结果
     */
    @Override
    public int updateFloorOrder(FloorOrder floorOrder)
    {
        floorOrder.setUpdateTime(DateUtils.getNowDate());
        return baseMapper.updateById(floorOrder);
    }

    /**
     * 批量删除地板订单
     * 
     * @param ids 需要删除的地板订单主键
     * @return 结果
     */
    @Override
    public int deleteFloorOrderByIds(String ids)
    {
        return baseMapper.deleteBatchIds(Arrays.asList(Convert.toIntArray(ids)));
    }

    /**
     * 删除地板订单信息
     * 
     * @param id 地板订单主键
     * @return 结果
     */
    @Override
    public int deleteFloorOrderById(Long id)
    {
        return baseMapper.deleteById(id);
    }

    @Override
    public int sendFloorSave(FloorOrder floorOrder) {
        int result = baseMapper.updateById(floorOrder);
        return result;
    }

    @Override
    public int surveyFloorSave(FloorOrder floorOrder) {
        return baseMapper.updateById(floorOrder);
    }

    @Override
    public int installFloorSave(FloorOrder floorOrder) {
        return baseMapper.updateById(floorOrder);
    }

    @Override
    public List<FloorOrderResp> selectFloorOrderRespList(FloorOrder floorOrder) {
        return baseMapper.selectFloorOrderRespList(floorOrder);
    }
}
