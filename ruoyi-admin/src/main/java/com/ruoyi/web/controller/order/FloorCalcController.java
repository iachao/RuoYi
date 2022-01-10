package com.ruoyi.web.controller.order;

import com.ruoyi.common.core.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
