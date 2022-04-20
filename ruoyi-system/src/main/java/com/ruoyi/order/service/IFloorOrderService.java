package com.ruoyi.order.service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.order.domain.FloorOrder;
import com.ruoyi.order.resp.FloorOrderResp;

/**
 * 地板订单Service接口
 * 
 * @author Chaos
 * @date 2021-12-25
 */
public interface IFloorOrderService extends IService<FloorOrder>
{
    /**
     * 查询地板订单
     * 
     * @param id 地板订单主键
     * @return 地板订单
     */
    FloorOrder selectFloorOrderById(Long id);

    /**
     * 查询地板订单列表
     * 
     * @param floorOrder 地板订单
     * @return 地板订单集合
     */
    List<FloorOrder> selectFloorOrderList(FloorOrder floorOrder);

    /**
     * 新增地板订单
     * 
     * @param floorOrder 地板订单
     * @return 结果
     */
    int insertFloorOrder(FloorOrder floorOrder);

    /**
     * 修改地板订单
     * 
     * @param floorOrder 地板订单
     * @return 结果
     */
    int updateFloorOrder(FloorOrder floorOrder);

    /**
     * 批量删除地板订单
     * 
     * @param ids 需要删除的地板订单主键集合
     * @return 结果
     */
    int deleteFloorOrderByIds(String ids);

    /**
     * 删除地板订单信息
     * 
     * @param id 地板订单主键
     * @return 结果
     */
    int deleteFloorOrderById(Long id);

    /**
     * 地板发货
     * @param floorOrder
     * @return
     */
    int sendFloorSave(FloorOrder floorOrder);

    /**
     * 地板测量
     * @param floorOrder
     * @return
     */
    int surveyFloorSave(FloorOrder floorOrder);

    /**
     * 地板安装
     * @param floorOrder
     * @return
     */
    int installFloorSave(FloorOrder floorOrder);

    List<FloorOrderResp> selectFloorOrderRespList(FloorOrder floorOrder);
}
