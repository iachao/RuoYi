package com.ruoyi.purchase.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.purchase.mapper.PurchaseFloorOrderMapper;
import com.ruoyi.purchase.domain.PurchaseFloorOrder;
import com.ruoyi.purchase.service.IPurchaseFloorOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.core.text.Convert;

/**
 * 采购木地板Service业务层处理
 * 
 * @author Chaos
 * @date 2022-03-26
 */
@Service
public class PurchaseFloorOrderServiceImpl extends ServiceImpl<PurchaseFloorOrderMapper,PurchaseFloorOrder> implements IPurchaseFloorOrderService
{
    @Autowired
    private PurchaseFloorOrderMapper purchaseFloorOrderMapper;

    /**
     * 查询采购木地板
     * 
     * @param id 采购木地板主键
     * @return 采购木地板
     */
    @Override
    public PurchaseFloorOrder selectPurchaseFloorOrderById(Long id)
    {
        return purchaseFloorOrderMapper.selectPurchaseFloorOrderById(id);
    }

    /**
     * 查询采购木地板列表
     * 
     * @param purchaseFloorOrder 采购木地板
     * @return 采购木地板
     */
    @Override
    public List<PurchaseFloorOrder> selectPurchaseFloorOrderList(PurchaseFloorOrder purchaseFloorOrder)
    {
        return purchaseFloorOrderMapper.selectPurchaseFloorOrderList(purchaseFloorOrder);
    }

    /**
     * 新增采购木地板
     * 
     * @param purchaseFloorOrder 采购木地板
     * @return 结果
     */
    @Override
    public int insertPurchaseFloorOrder(PurchaseFloorOrder purchaseFloorOrder)
    {
        purchaseFloorOrder.setCreateTime(DateUtils.getNowDate());
        return purchaseFloorOrderMapper.insertPurchaseFloorOrder(purchaseFloorOrder);
    }

    /**
     * 修改采购木地板
     * 
     * @param purchaseFloorOrder 采购木地板
     * @return 结果
     */
    @Override
    public int updatePurchaseFloorOrder(PurchaseFloorOrder purchaseFloorOrder)
    {
        purchaseFloorOrder.setUpdateTime(DateUtils.getNowDate());
        return purchaseFloorOrderMapper.updatePurchaseFloorOrder(purchaseFloorOrder);
    }

    /**
     * 批量删除采购木地板
     * 
     * @param ids 需要删除的采购木地板主键
     * @return 结果
     */
    @Override
    public int deletePurchaseFloorOrderByIds(String ids)
    {
        return purchaseFloorOrderMapper.deletePurchaseFloorOrderByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除采购木地板信息
     * 
     * @param id 采购木地板主键
     * @return 结果
     */
    @Override
    public int deletePurchaseFloorOrderById(Long id)
    {
        return purchaseFloorOrderMapper.deletePurchaseFloorOrderById(id);
    }
}
