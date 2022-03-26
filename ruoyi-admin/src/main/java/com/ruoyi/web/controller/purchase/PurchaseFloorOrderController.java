package com.ruoyi.web.controller.purchase;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.purchase.domain.PurchaseFloorOrder;
import com.ruoyi.purchase.service.IPurchaseFloorOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 采购木地板Controller
 * 
 * @author Chaos
 * @date 2022-03-26
 */
@Controller
@RequestMapping("/purchase/purchaseFloor")
public class PurchaseFloorOrderController extends BaseController
{
    private final String prefix = "purchase/purchaseFloor";

    @Autowired
    private IPurchaseFloorOrderService purchaseFloorOrderService;

    @RequiresPermissions("purchase:purchaseFloor:view")
    @GetMapping()
    public String purchaseFloor()
    {
        return prefix + "/purchaseFloor";
    }

    /**
     * 查询采购木地板列表
     */
    @RequiresPermissions("purchase:purchaseFloor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PurchaseFloorOrder purchaseFloorOrder)
    {
        startPage();
        List<PurchaseFloorOrder> list = purchaseFloorOrderService.selectPurchaseFloorOrderList(purchaseFloorOrder);
        return getDataTable(list);
    }

    /**
     * 导出采购木地板列表
     */
    @RequiresPermissions("purchase:purchaseFloor:export")
    @Log(title = "采购木地板", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PurchaseFloorOrder purchaseFloorOrder)
    {
        List<PurchaseFloorOrder> list = purchaseFloorOrderService.selectPurchaseFloorOrderList(purchaseFloorOrder);
        ExcelUtil<PurchaseFloorOrder> util = new ExcelUtil<PurchaseFloorOrder>(PurchaseFloorOrder.class);
        return util.exportExcel(list, "采购木地板数据");
    }

    /**
     * 新增采购木地板
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存采购木地板
     */
    @RequiresPermissions("purchase:purchaseFloor:add")
    @Log(title = "采购木地板", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PurchaseFloorOrder purchaseFloorOrder)
    {
        return toAjax(purchaseFloorOrderService.insertPurchaseFloorOrder(purchaseFloorOrder));
    }

    /**
     * 修改采购木地板
     */
    @RequiresPermissions("purchase:purchaseFloor:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        PurchaseFloorOrder purchaseFloorOrder = purchaseFloorOrderService.selectPurchaseFloorOrderById(id);
        mmap.put("purchaseFloorOrder", purchaseFloorOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存采购木地板
     */
    @RequiresPermissions("purchase:purchaseFloor:edit")
    @Log(title = "采购木地板", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PurchaseFloorOrder purchaseFloorOrder)
    {
        return toAjax(purchaseFloorOrderService.updatePurchaseFloorOrder(purchaseFloorOrder));
    }

    /**
     * 删除采购木地板
     */
    @RequiresPermissions("purchase:purchaseFloor:remove")
    @Log(title = "采购木地板", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(purchaseFloorOrderService.deletePurchaseFloorOrderByIds(ids));
    }
}
