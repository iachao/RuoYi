package com.ruoyi.system.resp;

import com.ruoyi.system.model.FloorCalcResult;
import lombok.Data;

@Data
public class FloorCalcResp {

    // 横向铺结果 长作长铺地板
    private FloorCalcResult lengthAsLengthResult;

    // 众向铺结果 长作宽铺地板
    private FloorCalcResult lengthAsWidthResult;

}
