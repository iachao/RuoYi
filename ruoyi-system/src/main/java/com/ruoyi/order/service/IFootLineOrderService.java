package com.ruoyi.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.order.domain.FootLineOrder;
import com.ruoyi.order.resp.FootLineOrderResp;

import java.util.List;

/**
 * 踢脚线订单Service接口
 * 
 * @author Chaos
 * @date 2022-04-23
 */
public interface IFootLineOrderService extends IService<FootLineOrder>
{
    /**
     * 查询踢脚线订单
     *
     * @param id 踢脚线订单主键
     * @return 踢脚线订单
     */
        FootLineOrder selectFootLineOrderById(Long id);

    /**
     * 查询踢脚线订单列表
     *
     * @param footLineOrder 踢脚线订单
     * @return 踢脚线订单集合
     */
    List<FootLineOrder> selectFootLineOrderList(FootLineOrder footLineOrder);

    /**
     * 新增踢脚线订单
     *
     * @param footLineOrder 踢脚线订单
     * @return 结果
     */
    int insertFootLineOrder(FootLineOrder footLineOrder);

    /**
     * 修改踢脚线订单
     *
     * @param footLineOrder 踢脚线订单
     * @return 结果
     */
    int updateFootLineOrder(FootLineOrder footLineOrder);

    /**
     * 批量删除踢脚线订单
     *
     * @param ids 需要删除的踢脚线订单主键集合
     * @return 结果
     */
    int deleteFootLineOrderByIds(String ids);

    /**
     * 删除踢脚线订单信息
     *
     * @param id 踢脚线订单主键
     * @return 结果
     */
    int deleteFootLineOrderById(Long id);

    List<FootLineOrderResp> selectFootLineOrderRespList(FootLineOrder footLineOrder);
}
