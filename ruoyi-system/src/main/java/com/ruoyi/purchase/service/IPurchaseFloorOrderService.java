package com.ruoyi.purchase.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.purchase.domain.PurchaseFloorOrder;

import java.util.List;

/**
 * 采购木地板Service接口
 * 
 * @author Chaos
 * @date 2022-03-26
 */
public interface IPurchaseFloorOrderService extends IService<PurchaseFloorOrder>
{
    /**
     * 查询采购木地板
     * 
     * @param id 采购木地板主键
     * @return 采购木地板
     */
        PurchaseFloorOrder selectPurchaseFloorOrderById(Long id);

    /**
     * 查询采购木地板列表
     * 
     * @param purchaseFloorOrder 采购木地板
     * @return 采购木地板集合
     */
    List<PurchaseFloorOrder> selectPurchaseFloorOrderList(PurchaseFloorOrder purchaseFloorOrder);

    /**
     * 新增采购木地板
     * 
     * @param purchaseFloorOrder 采购木地板
     * @return 结果
     */
    int insertPurchaseFloorOrder(PurchaseFloorOrder purchaseFloorOrder);

    /**
     * 修改采购木地板
     * 
     * @param purchaseFloorOrder 采购木地板
     * @return 结果
     */
    int updatePurchaseFloorOrder(PurchaseFloorOrder purchaseFloorOrder);

    /**
     * 批量删除采购木地板
     * 
     * @param ids 需要删除的采购木地板主键集合
     * @return 结果
     */
    int deletePurchaseFloorOrderByIds(String ids);

    /**
     * 删除采购木地板信息
     * 
     * @param id 采购木地板主键
     * @return 结果
     */
    int deletePurchaseFloorOrderById(Long id);
}
