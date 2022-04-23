package com.ruoyi.order.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.order.resp.FootLineOrderResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.order.mapper.FootLineOrderMapper;
import com.ruoyi.order.domain.FootLineOrder;
import com.ruoyi.order.service.IFootLineOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;

/**
 * 踢脚线订单Service业务层处理
 * 
 * @author Chaos
 * @date 2022-04-23
 */
@Service
public class FootLineOrderServiceImpl extends ServiceImpl<FootLineOrderMapper,FootLineOrder> implements IFootLineOrderService
{
    @Autowired
    private FootLineOrderMapper footLineOrderMapper;

    /**
     * 查询踢脚线订单
     * 
     * @param id 踢脚线订单主键
     * @return 踢脚线订单
     */
    @Override
    public FootLineOrder selectFootLineOrderById(Long id)
    {
        return footLineOrderMapper.selectFootLineOrderById(id);
    }

    /**
     * 查询踢脚线订单列表
     * 
     * @param footLineOrder 踢脚线订单
     * @return 踢脚线订单
     */
    @Override
    public List<FootLineOrder> selectFootLineOrderList(FootLineOrder footLineOrder)
    {
        return footLineOrderMapper.selectFootLineOrderList(footLineOrder);
    }

    /**
     * 新增踢脚线订单
     * 
     * @param footLineOrder 踢脚线订单
     * @return 结果
     */
    @Override
    public int insertFootLineOrder(FootLineOrder footLineOrder)
    {
        footLineOrder.setCreateTime(DateUtils.getNowDate());
        return footLineOrderMapper.insertFootLineOrder(footLineOrder);
    }

    /**
     * 修改踢脚线订单
     * 
     * @param footLineOrder 踢脚线订单
     * @return 结果
     */
    @Override
    public int updateFootLineOrder(FootLineOrder footLineOrder)
    {
        footLineOrder.setUpdateTime(DateUtils.getNowDate());
        return footLineOrderMapper.updateFootLineOrder(footLineOrder);
    }

    /**
     * 批量删除踢脚线订单
     * 
     * @param ids 需要删除的踢脚线订单主键
     * @return 结果
     */
    @Override
    public int deleteFootLineOrderByIds(String ids)
    {
        return footLineOrderMapper.deleteFootLineOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除踢脚线订单信息
     * 
     * @param id 踢脚线订单主键
     * @return 结果
     */
    @Override
    public int deleteFootLineOrderById(Long id)
    {
        return footLineOrderMapper.deleteFootLineOrderById(id);
    }

    @Override
    public List<FootLineOrderResp> selectFootLineOrderRespList(FootLineOrder footLineOrder) {
        return footLineOrderMapper.selectFootLineOrderRespList(footLineOrder);
    }
}
