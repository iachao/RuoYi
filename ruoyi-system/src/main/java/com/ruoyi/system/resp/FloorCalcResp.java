package com.ruoyi.system.resp;

import com.ruoyi.system.model.FloorCalcParam;
import com.ruoyi.system.model.FloorCalcResult;
import lombok.Data;

import java.util.List;

/**
 * 地板计算后返回结果
 */
@Data
public class FloorCalcResp {

    private List<FloorCalcParam> floorCalcParam;

    private FloorCalcResult floorCalcResult;

}
