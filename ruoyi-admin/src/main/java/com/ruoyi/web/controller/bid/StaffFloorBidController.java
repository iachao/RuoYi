package com.ruoyi.web.controller.bid;

import com.ruoyi.bid.domain.FloorBid;
import com.ruoyi.bid.service.IFloorBidService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * 地板报价Controller
 *
 * @author Chaos
 * @date 2022-03-26
 */
@Controller
@RequestMapping("/bid/staffFloorBid")
public class StaffFloorBidController extends BaseController
{
    private final String prefix = "bid/staffFloorBid";

    @Autowired
    private IFloorBidService floorBidService;


    @RequiresPermissions("bid:staffFloorBid:view")
    @GetMapping()
    public String staffFloorBid()
    {
        return prefix + "/staffFloorBid";
    }

    /**
     * 店内员工查询地板报价列表
     */
    @RequiresPermissions("bid:staffFloorBid:list")
    @PostMapping("/staffFloorBidList")
    @ResponseBody
    public TableDataInfo staffFloorBidList(FloorBid floorBid)
    {
        startPage();
        List<FloorBid> list = floorBidService.selectStaffFloorBidList(floorBid);
        return getDataTable(list);
    }
}
