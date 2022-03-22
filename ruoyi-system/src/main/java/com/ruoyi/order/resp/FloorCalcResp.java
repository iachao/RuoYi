package com.ruoyi.order.resp;

import com.ruoyi.order.model.FloorCalcParam;
import com.ruoyi.order.model.FloorCalcResult;
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
