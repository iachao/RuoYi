package com.ruoyi.web.controller.bid;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
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
import com.ruoyi.bid.domain.FloorBid;
import com.ruoyi.bid.service.IFloorBidService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地板报价Controller
 * 
 * @author Chaos
 * @date 2022-03-26
 */
@Controller
@RequestMapping("/bid/floorBid")
public class FloorBidController extends BaseController
{
    private final String prefix = "bid/floorBid";

    @Autowired
    private IFloorBidService floorBidService;

    @RequiresPermissions("bid:floorBid:view")
    @GetMapping()
    public String floorBid()
    {
        return prefix + "/floorBid";
    }

    /**
     * 查询地板报价列表
     */
    @RequiresPermissions("bid:floorBid:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(FloorBid floorBid)
    {
        startPage();
        List<FloorBid> list = floorBidService.selectFloorBidList(floorBid);
        return getDataTable(list);
    }

    /**
     * 导出地板报价列表
     */
    @RequiresPermissions("bid:floorBid:export")
    @Log(title = "地板报价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(FloorBid floorBid)
    {
        List<FloorBid> list = floorBidService.selectFloorBidList(floorBid);
        ExcelUtil<FloorBid> util = new ExcelUtil<FloorBid>(FloorBid.class);
        return util.exportExcel(list, "地板报价数据");
    }

    /**
     * 新增地板报价
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存地板报价
     */
    @RequiresPermissions("bid:floorBid:add")
    @Log(title = "地板报价", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(FloorBid floorBid)
    {
        floorBid.setCreateBy(getLoginName());
        floorBid.setMarketPrice(floorBid.getPrice().multiply(new BigDecimal(3.5).setScale(0, RoundingMode.UP)));
        floorBid.setVisiblePrice(floorBid.getPrice().multiply(new BigDecimal(1.2).setScale(0, RoundingMode.UP)));
        return toAjax(floorBidService.insertFloorBid(floorBid));
    }

    /**
     * 修改地板报价
     */
    @RequiresPermissions("bid:floorBid:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        FloorBid floorBid = floorBidService.selectFloorBidById(id);
        mmap.put("floorBid", floorBid);
        return prefix + "/edit";
    }

    /**
     * 修改保存地板报价
     */
    @RequiresPermissions("bid:floorBid:edit")
    @Log(title = "地板报价", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(FloorBid floorBid)
    {
        floorBid.setUpdateBy(getLoginName());
        floorBid.setMarketPrice(floorBid.getPrice().multiply(new BigDecimal(3.5).setScale(0, RoundingMode.UP)));
        floorBid.setVisiblePrice(floorBid.getPrice().multiply(new BigDecimal(1.2).setScale(0, RoundingMode.UP)));
        return toAjax(floorBidService.updateFloorBid(floorBid));
    }

    /**
     * 删除地板报价
     */
    @RequiresPermissions("bid:floorBid:remove")
    @Log(title = "地板报价", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(floorBidService.deleteFloorBidByIds(ids));
    }
}
