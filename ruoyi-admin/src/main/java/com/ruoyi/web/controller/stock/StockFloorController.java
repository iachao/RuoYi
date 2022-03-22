package com.ruoyi.web.controller.stock;

import java.util.List;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.stock.domain.StockFloor;
import com.ruoyi.stock.service.IStockFloorService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地板库存Controller
 * 
 * @author Chaos
 * @date 2021-12-18
 */
@Controller
@RequestMapping("/stock/floor")
public class StockFloorController extends BaseController
{
    private final String prefix = "stock/floor";

    @Autowired
    private IStockFloorService stockFloorService;

    @RequiresPermissions("stock:floor:view")
    @GetMapping()
    public String floor()
    {
        return prefix + "/floor";
    }

    /**
     * 查询地板库存列表
     */
    @RequiresPermissions("stock:floor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StockFloor stockFloor)
    {
        startPage();
        List<StockFloor> list = stockFloorService.selectStockFloorList(stockFloor);
        return getDataTable(list);
    }

    /**
     * 导出地板库存列表
     */
    @RequiresPermissions("stock:floor:export")
    @Log(title = "地板库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StockFloor stockFloor)
    {
        List<StockFloor> list = stockFloorService.selectStockFloorList(stockFloor);
        ExcelUtil<StockFloor> util = new ExcelUtil<StockFloor>(StockFloor.class);
        return util.exportExcel(list, "地板库存数据");
    }

    /**
     * 新增地板库存
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存地板库存
     */
    @RequiresPermissions("stock:floor:add")
    @Log(title = "地板库存", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StockFloor stockFloor)
    {
        StockFloor s = new StockFloor();
        s.setFloorNumber(stockFloor.getFloorNumber());
        List<StockFloor> r = stockFloorService.selectStockFloorList(s);
        if(CollectionUtils.isEmpty(r)) {
            stockFloor.setCreateBy(getLoginName());
            return toAjax(stockFloorService.insertStockFloor(stockFloor));
        }else{
            return error("该地板型号已存在");
        }
    }

    /**
     * 修改地板库存
     */
    @RequiresPermissions("stock:floor:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        StockFloor stockFloor = stockFloorService.selectStockFloorById(id);
        mmap.put("stockFloor", stockFloor);
        return prefix + "/edit";
    }

    /**
     * 修改保存地板库存
     */
    @RequiresPermissions("stock:floor:edit")
    @Log(title = "地板库存", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StockFloor stockFloor)
    {
        stockFloor.setUpdateBy(getLoginName());
        return toAjax(stockFloorService.updateStockFloor(stockFloor));
    }

    /**
     * 删除地板库存
     */
    @RequiresPermissions("stock:floor:remove")
    @Log(title = "地板库存", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(stockFloorService.deleteStockFloorByIds(ids));
    }
}
