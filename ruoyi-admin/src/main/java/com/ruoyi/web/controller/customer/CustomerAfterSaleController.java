package com.ruoyi.web.controller.customer;

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
import com.ruoyi.customer.domain.CustomerAfterSale;
import com.ruoyi.customer.service.ICustomerAfterSaleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户售后服务Controller
 * 
 * @author Chaos
 * @date 2022-03-22
 */
@Controller
@RequestMapping("/customer/afterSale")
public class CustomerAfterSaleController extends BaseController
{
    private final String prefix = "customer/afterSale";

    @Autowired
    private ICustomerAfterSaleService customerAfterSaleService;

    @RequiresPermissions("customer:afterSale:view")
    @GetMapping()
    public String afterSale()
    {
        return prefix + "/afterSale";
    }

    /**
     * 查询客户售后服务列表
     */
    @RequiresPermissions("customer:afterSale:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CustomerAfterSale customerAfterSale)
    {
        startPage();
        List<CustomerAfterSale> list = customerAfterSaleService.selectCustomerAfterSaleList(customerAfterSale);
        return getDataTable(list);
    }

    /**
     * 导出客户售后服务列表
     */
    @RequiresPermissions("customer:afterSale:export")
    @Log(title = "客户售后服务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CustomerAfterSale customerAfterSale)
    {
        List<CustomerAfterSale> list = customerAfterSaleService.selectCustomerAfterSaleList(customerAfterSale);
        ExcelUtil<CustomerAfterSale> util = new ExcelUtil<CustomerAfterSale>(CustomerAfterSale.class);
        return util.exportExcel(list, "客户售后服务数据");
    }

    /**
     * 新增客户售后服务
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户售后服务
     */
    @RequiresPermissions("customer:afterSale:add")
    @Log(title = "客户售后服务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CustomerAfterSale customerAfterSale)
    {
        return toAjax(customerAfterSaleService.insertCustomerAfterSale(customerAfterSale));
    }

    /**
     * 修改客户售后服务
     */
    @RequiresPermissions("customer:afterSale:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CustomerAfterSale customerAfterSale = customerAfterSaleService.selectCustomerAfterSaleById(id);
        mmap.put("customerAfterSale", customerAfterSale);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户售后服务
     */
    @RequiresPermissions("customer:afterSale:edit")
    @Log(title = "客户售后服务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CustomerAfterSale customerAfterSale)
    {
        return toAjax(customerAfterSaleService.updateCustomerAfterSale(customerAfterSale));
    }

    /**
     * 删除客户售后服务
     */
    @RequiresPermissions("customer:afterSale:remove")
    @Log(title = "客户售后服务", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(customerAfterSaleService.deleteCustomerAfterSaleByIds(ids));
    }
}
