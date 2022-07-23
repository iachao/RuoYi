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
@RequestMapping("/bid/directFloorBid")
public class DirectFloorBidController extends BaseController
{
    private final String prefix = "bid/directFloorBid";

    @Autowired
    private IFloorBidService floorBidService;


    @RequiresPermissions("bid:directFloorBid:view")
    @GetMapping()
    public String directFloorBid()
    {
        return prefix + "/directFloorBid";
    }

    /**
     * 经销商 查询地板报价列表
     */
    @RequiresPermissions("bid:directFloorBid:list")
    @PostMapping("/directFloorBidList")
    @ResponseBody
    public TableDataInfo directFloorBidList(FloorBid floorBid)
    {
        startPage();
        List<FloorBid> list = floorBidService.directFloorBidList(floorBid);
        return getDataTable(list);
    }
}
