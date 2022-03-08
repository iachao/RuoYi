package com.ruoyi.web.controller.order;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.CustomerFloorData;
import com.ruoyi.system.service.ICustomerFloorDataService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户地板测量数据Controller
 * 
 * @author Chaos
 * @date 2022-03-08
 */
@Controller
@RequestMapping("order/customer/floorData")
public class CustomerFloorDataController extends BaseController
{
    private final String prefix = "order/customer/floorData";

    @Autowired
    private ICustomerFloorDataService customerFloorDataService;

    @RequiresPermissions("customer:floorData:view")
    @GetMapping()
    public String floorData()
    {
        return prefix + "/floorData";
    }

    /**
     * 查询客户地板测量数据列表
     */
    @RequiresPermissions("customer:floorData:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CustomerFloorData customerFloorData)
    {
        startPage();
        List<CustomerFloorData> list = customerFloorDataService.selectCustomerFloorDataList(customerFloorData);
        return getDataTable(list);
    }

    /**
     * 导出客户地板测量数据列表
     */
    @RequiresPermissions("customer:floorData:export")
    @Log(title = "客户地板测量数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CustomerFloorData customerFloorData)
    {
        List<CustomerFloorData> list = customerFloorDataService.selectCustomerFloorDataList(customerFloorData);
        ExcelUtil<CustomerFloorData> util = new ExcelUtil<CustomerFloorData>(CustomerFloorData.class);
        return util.exportExcel(list, "客户地板测量数据数据");
    }

    /**
     * 新增客户地板测量数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户地板测量数据
     */
    @RequiresPermissions("customer:floorData:add")
    @Log(title = "客户地板测量数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CustomerFloorData customerFloorData)
    {
        return toAjax(customerFloorDataService.insertCustomerFloorData(customerFloorData));
    }

    /**
     * 修改客户地板测量数据
     */
    @RequiresPermissions("customer:floorData:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        CustomerFloorData customerFloorData = customerFloorDataService.selectCustomerFloorDataById(id);
        mmap.put("customerFloorData", customerFloorData);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户地板测量数据
     */
    @RequiresPermissions("customer:floorData:edit")
    @Log(title = "客户地板测量数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CustomerFloorData customerFloorData)
    {
        return toAjax(customerFloorDataService.updateCustomerFloorData(customerFloorData));
    }

    /**
     * 删除客户地板测量数据
     */
    @RequiresPermissions("customer:floorData:remove")
    @Log(title = "客户地板测量数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(customerFloorDataService.deleteCustomerFloorDataByIds(ids));
    }
}
