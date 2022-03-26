package com.ruoyi.purchase.mapper;

import java.util.List;
import com.ruoyi.purchase.domain.PurchaseFloorOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 采购木地板Mapper接口
 * 
 * @author Chaos
 * @date 2022-03-26
 */
public interface PurchaseFloorOrderMapper extends BaseMapper<PurchaseFloorOrder>
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
     * 删除采购木地板
     * 
     * @param id 采购木地板主键
     * @return 结果
     */
    int deletePurchaseFloorOrderById(Long id);

    /**
     * 批量删除采购木地板
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deletePurchaseFloorOrderByIds(String[] ids);
}
