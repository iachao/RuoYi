package com.ruoyi.web.controller.order;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.order.domain.CustomerOrder;
import com.ruoyi.order.domain.FootLineOrder;
import com.ruoyi.order.resp.FootLineOrderResp;
import com.ruoyi.order.service.ICustomerOrderService;
import com.ruoyi.order.service.IFootLineOrderService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 踢脚线订单Controller
 * 
 * @author Chaos
 * @date 2022-04-23
 */
@Controller
@RequestMapping("/order/footLine")
public class FootLineOrderController extends BaseController
{
    private final String prefix = "order/footLine";

    @Autowired
    private IFootLineOrderService footLineOrderService;
    @Autowired
    private ICustomerOrderService customerOrderService;
    @RequiresPermissions("order:footLine:view")
    @GetMapping()
    public String footLine()
    {
        return prefix + "/footLine";
    }

    /**
     * 查询踢脚线订单列表
     */
    @RequiresPermissions("order:footLine:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FootLineOrder footLineOrder)
    {
        startPage();
        List<FootLineOrderResp> list = footLineOrderService.selectFootLineOrderRespList(footLineOrder);
        return getDataTable(list);
    }

    /**
     * 导出踢脚线订单列表
     */
    @RequiresPermissions("order:footLine:export")
    @Log(title = "脚线订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FootLineOrder footLineOrder)
    {
        List<FootLineOrder> list = footLineOrderService.selectFootLineOrderList(footLineOrder);
        ExcelUtil<FootLineOrder> util = new ExcelUtil<FootLineOrder>(FootLineOrder.class);
        return util.exportExcel(list, "踢脚线订单数据");
    }

    /**
     * 新增踢脚线订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存踢脚线订单
     */
    @RequiresPermissions("order:footLine:add")
    @Log(title = "脚线订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FootLineOrder footLineOrder)
    {
        footLineOrder.setCreateBy(getLoginName());
        return toAjax(footLineOrderService.insertFootLineOrder(footLineOrder));
    }

    /**
     * 修改踢脚线订单
     */
    @RequiresPermissions("order:footLine:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FootLineOrder footLineOrder = footLineOrderService.selectFootLineOrderById(id);
        CustomerOrder customerOrder = customerOrderService.selectCustomerOrderById(footLineOrder.getCustomerId());
        footLineOrder.setCustomerInfo(customerOrder.getCustomerInfo());
        mmap.put("footLineOrder", footLineOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存踢脚线订单
     */
    @RequiresPermissions("order:footLine:edit")
    @Log(title = "脚线订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FootLineOrder footLineOrder)
    {
        footLineOrder.setUpdateBy(getLoginName());
        return toAjax(footLineOrderService.updateFootLineOrder(footLineOrder));
    }

    /**
     * 删除踢脚线订单
     */
    @RequiresPermissions("order:footLine:remove")
    @Log(title = "脚线订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(footLineOrderService.deleteFootLineOrderByIds(ids));
    }
}
