package com.ruoyi.order.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.order.domain.FloorOrder;
import com.ruoyi.order.mapper.FloorOrderMapper;
import com.ruoyi.order.resp.FloorOrderResp;
import com.ruoyi.order.service.IFloorOrderService;
import com.ruoyi.purchase.domain.PurchaseFloorOrder;
import com.ruoyi.purchase.mapper.PurchaseFloorOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 地板订单Service业务层处理
 * 
 * @author Chaos
 * @date 2021-12-25
 */
@Service
public class FloorOrderServiceImpl extends ServiceImpl<FloorOrderMapper, FloorOrder> implements IFloorOrderService
{
    @Autowired
    private FloorOrderMapper floorOrderMapper;

    /**
     * 查询地板订单
     * 
     * @param id 地板订单主键
     * @return 地板订单
     */
    @Override
    public FloorOrder selectFloorOrderById(Long id)
    {
        return floorOrderMapper.selectFloorOrderById(id);
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
        return floorOrderMapper.selectFloorOrderList(floorOrder);
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
        return floorOrderMapper.insertFloorOrder(floorOrder);
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
        return floorOrderMapper.updateFloorOrder(floorOrder);
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
        return floorOrderMapper.deleteFloorOrderByIds(Convert.toStrArray(ids));
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
        return floorOrderMapper.deleteFloorOrderById(id);
    }

    @Override
    public int sendFloorSave(FloorOrder floorOrder) {
        int result = floorOrderMapper.updateFloorOrder(floorOrder);
        return result;
    }

    @Override
    public int surveyFloorSave(FloorOrder floorOrder) {
        return floorOrderMapper.updateFloorOrder(floorOrder);
    }

    @Override
    public int installFloorSave(FloorOrder floorOrder) {
        return floorOrderMapper.updateFloorOrder(floorOrder);
    }

    @Override
    public List<FloorOrderResp> selectFloorOrderRespList(FloorOrder floorOrder) {
        return floorOrderMapper.selectFloorOrderRespList(floorOrder);
    }
}
