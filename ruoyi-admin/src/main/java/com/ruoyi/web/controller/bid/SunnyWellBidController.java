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
@RequestMapping("/bid/sunnyWellBid")
public class SunnyWellBidController extends BaseController
{
    private final String prefix = "bid/sunnyWellBid";


    /**
     * 原木门
     * @return
     */
    @RequiresPermissions("bid:sunnyWellBid:originalWoodDoor")
    @GetMapping("/originalWoodDoor")
    public String originalWoodDoor()
    {
        return prefix + "/originalWoodDoor";
    }

    /**
     * 实木复合门
     * @return
     */
    @RequiresPermissions("bid:sunnyWellBid:compositeWoodDoor")
    @GetMapping("/compositeWoodDoor")
    public String compositeWoodDoor()
    {
        return prefix + "/compositeWoodDoor";
    }

    /**
     * 新实木门
     * @return
     */
    @RequiresPermissions("bid:sunnyWellBid:newWoodDoor")
    @GetMapping("/newWoodDoor")
    public String newWoodDoor()
    {
        return prefix + "/newWoodDoor";
    }

    /**
     * 标准门型
     * @return
     */
    @RequiresPermissions("bid:sunnyWellBid:standardWoodDoor")
    @GetMapping("/standardWoodDoor")
    public String standardWoodDoor()
    {
        return prefix + "/standardWoodDoor";
    }

    /**
     * 大柱
     * @return
     */
    @RequiresPermissions("bid:sunnyWellBid:bigPillar")
    @GetMapping("/bigPillar")
    public String bigPillar()
    {
        return prefix + "/bigPillar";
    }

    /**
     * 小柱
     * @return
     */
    @RequiresPermissions("bid:sunnyWellBid:smallPillar")
    @GetMapping("/smallPillar")
    public String smallPillar()
    {
        return prefix + "/smallPillar";
    }

    /**
     * 踏步扶手
     * @return
     */
    @RequiresPermissions("bid:sunnyWellBid:armrest")
    @GetMapping("/armrest")
    public String armrest()
    {
        return prefix + "/armrest";
    }

    /**
     * 栅格
     * @return
     */
    @RequiresPermissions("bid:sunnyWellBid:shanGe")
    @GetMapping("/shanGe")
    public String shanGe()
    {
        return prefix + "/shanGe";
    }

    /**
     * 家居
     * @return
     */
    @RequiresPermissions("bid:sunnyWellBid:household")
    @GetMapping("/household")
    public String household()
    {
        return prefix + "/household";
    }

}
