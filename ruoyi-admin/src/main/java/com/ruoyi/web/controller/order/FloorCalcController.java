package com.ruoyi.web.controller.order;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.req.FloorCalcReq;
import com.ruoyi.system.resp.FloorCalcResp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 地板计算Controller
 *
 * @author Chaos
 * @date 2022-01-11
 */
@Controller
@RequestMapping("order/floor/calc")
public class FloorCalcController  extends BaseController {
    private final String prefix = "order/floor/calc";


    @GetMapping()
    public String calc()
    {
        return prefix + "/calc";
    }

    @PostMapping("/calcFloor")
    @ResponseBody
    public AjaxResult calcFloor(@RequestBody List<FloorCalcReq> req){
        // 验证数据正确性

        return AjaxResult.success(new FloorCalcResp());
    }

}
