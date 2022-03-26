package com.ruoyi.web.controller.order;

import java.util.List;

import com.ruoyi.common.enums.business.FloorOrderStatusEnum;
import com.ruoyi.order.domain.CustomerOrder;
import com.ruoyi.order.domain.FloorOrder;
import com.ruoyi.order.service.ICustomerOrderService;
import com.ruoyi.order.service.IFloorOrderService;
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
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地板订单Controller
 * 
 * @author Chaos
 * @date 2021-12-25
 */
@Controller
@RequestMapping("/order/floor")
public class FloorOrderController extends BaseController
{
    private final String prefix = "order/floor";

    @Autowired
    private IFloorOrderService floorOrderService;
    @Autowired
    private ICustomerOrderService customerOrderService;

    @RequiresPermissions("order:floor:view")
    @GetMapping()
    public String floor()
    {
        return prefix + "/floor";
    }

    /**
     * 查询地板订单列表
     */
    @RequiresPermissions("order:floor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FloorOrder floorOrder)
    {
        startPage();
        List<FloorOrder> list = floorOrderService.selectFloorOrderList(floorOrder);
        return getDataTable(list);
    }

    /**
     * 导出地板订单列表
     */
    @RequiresPermissions("order:floor:export")
    @Log(title = "地板订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FloorOrder floorOrder)
    {
        List<FloorOrder> list = floorOrderService.selectFloorOrderList(floorOrder);
        ExcelUtil<FloorOrder> util = new ExcelUtil<FloorOrder>(FloorOrder.class);
        return util.exportExcel(list, "地板订单数据");
    }

    /**
     * 新增地板订单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存地板订单
     */
    @RequiresPermissions("order:floor:add")
    @Log(title = "地板订单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FloorOrder floorOrder)
    {
        return toAjax(floorOrderService.insertFloorOrder(floorOrder));
    }

    /**
     * 修改地板订单
     */
    @RequiresPermissions("order:floor:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FloorOrder floorOrder = floorOrderService.selectFloorOrderById(id);
        CustomerOrder customerOrder = customerOrderService.selectCustomerOrderById(floorOrder.getCustomerId());
        floorOrder.setCustomerInfo(customerOrder.getCustomerInfo());
        mmap.put("floorOrder", floorOrder);
        return prefix + "/edit";
    }


    /**
     * 修改保存地板订单
     */
    @RequiresPermissions("order:floor:edit")
    @Log(title = "地板订单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FloorOrder floorOrder)
    {
        return toAjax(floorOrderService.updateFloorOrder(floorOrder));
    }

    /**
     * 删除地板订单
     */
    @RequiresPermissions("order:floor:remove")
    @Log(title = "地板订单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(floorOrderService.deleteFloorOrderByIds(ids));
    }

    @RequiresPermissions("order:floor:survey")
    @GetMapping("/survey/{id}")
    public String surveyFloor(@PathVariable("id") Long id, ModelMap mmap)
    {
        FloorOrder floorOrder = floorOrderService.selectFloorOrderById(id);
        mmap.put("floorOrder", floorOrder);
        return prefix + "/surveyFloor";
    }

    @RequiresPermissions("order:floor:send")
    @GetMapping("/send/{id}")
    public String sendFloor(@PathVariable("id") Long id, ModelMap mmap)
    {
        FloorOrder floorOrder = floorOrderService.selectFloorOrderById(id);
        mmap.put("floorOrder", floorOrder);
        return prefix + "/sendFloor";
    }

    @RequiresPermissions("order:floor:install")
    @GetMapping("/install/{id}")
    public String installFloor(@PathVariable("id") Long id, ModelMap mmap)
    {
        FloorOrder floorOrder = floorOrderService.selectFloorOrderById(id);
        mmap.put("floorOrder", floorOrder);
        return prefix + "/installFloor";
    }

    /**
     * 地板测量
     */
    @RequiresPermissions("order:floor:survey")
    @Log(title = "地板测量", businessType = BusinessType.UPDATE)
    @PostMapping("/surveyFloorSave")
    @ResponseBody
    public AjaxResult surveyFloorSave(FloorOrder floorOrder)
    {
        floorOrder.setStatus(FloorOrderStatusEnum.WAIT_SEND.getKey());
        return toAjax(floorOrderService.surveyFloorSave(floorOrder));
    }

    /**
     * 地板发货
     */
    @RequiresPermissions("order:floor:send")
    @Log(title = "地板发货", businessType = BusinessType.UPDATE)
    @PostMapping("/sendFloorSave")
    @ResponseBody
    public AjaxResult sendFloorSave(FloorOrder floorOrder)
    {
        floorOrder.setStatus(FloorOrderStatusEnum.WAIT_RECEIVED.getKey());
        return toAjax(floorOrderService.sendFloorSave(floorOrder));
    }

    /**
     * 地板安装
     */
    @RequiresPermissions("order:floor:install")
    @Log(title = "地板安装", businessType = BusinessType.UPDATE)
    @PostMapping("/installFloorSave")
    @ResponseBody
    public AjaxResult installFloorSave(FloorOrder floorOrder)
    {
        floorOrder.setStatus(FloorOrderStatusEnum.COMPLETED.getKey());
        return toAjax(floorOrderService.installFloorSave(floorOrder));
    }
}
