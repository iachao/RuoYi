package com.ruoyi.web.controller.bid;

import com.ruoyi.bid.domain.FloorBid;
import com.ruoyi.bid.service.IFloorBidService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.page.TableDataInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
