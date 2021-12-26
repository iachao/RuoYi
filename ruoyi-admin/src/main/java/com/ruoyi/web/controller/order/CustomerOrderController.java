package com.ruoyi.web.controller.order;

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
import com.ruoyi.system.domain.CustomerOrder;
import com.ruoyi.system.service.ICustomerOrderService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户Controller
 * 
 * @author Chaos
 * @date 2021-12-18
 */
@Controller
@RequestMapping("/order/customer")
public class CustomerOrderController extends BaseController
{
    private final String prefix = "order/customer";

    @Autowired
    private ICustomerOrderService customerOrderService;

    @RequiresPermissions("order:customer:view")
    @GetMapping()
    public String customer()
    {
        return prefix + "/customer";
    }

    /**
     * 查询客户列表
     */
    @RequiresPermissions("order:customer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CustomerOrder customerOrder)
    {
        startPage();
        List<CustomerOrder> list = customerOrderService.selectCustomerOrderList(customerOrder);
        return getDataTable(list);
    }

    /**
     * 导出客户列表
     */
    @RequiresPermissions("order:customer:export")
    @Log(title = "客户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CustomerOrder customerOrder)
    {
        List<CustomerOrder> list = customerOrderService.selectCustomerOrderList(customerOrder);
        ExcelUtil<CustomerOrder> util = new ExcelUtil<CustomerOrder>(CustomerOrder.class);
        return util.exportExcel(list, "客户数据");
    }

    /**
     * 新增客户
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户
     */
    @RequiresPermissions("order:customer:add")
    @Log(title = "客户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CustomerOrder customerOrder)
    {
        customerOrder.setCreateBy(getLoginName());
        return toAjax(customerOrderService.insertCustomerOrder(customerOrder));
    }

    /**
     * 修改客户
     */
    @RequiresPermissions("order:customer:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CustomerOrder customerOrder = customerOrderService.selectCustomerOrderById(id);
        mmap.put("customerOrder", customerOrder);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户
     */
    @RequiresPermissions("order:customer:edit")
    @Log(title = "客户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CustomerOrder customerOrder)
    {
        customerOrder.setUpdateBy(getLoginName());
        return toAjax(customerOrderService.updateCustomerOrder(customerOrder));
    }

    /**
     * 删除客户
     */
    @RequiresPermissions("order:customer:remove")
    @Log(title = "客户", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(customerOrderService.deleteCustomerOrderByIds(ids));
    }

    /**
     * 查询客户
     */
    @GetMapping("/selectById/{id}")
    @ResponseBody
    public AjaxResult selectById(@PathVariable("id") Long id)
    {
        CustomerOrder customerOrder = customerOrderService.selectCustomerOrderById(id);
        return AjaxResult.success(customerOrder);
    }
}
