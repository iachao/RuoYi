package com.ruoyi.system.req;

import com.ruoyi.system.model.FloorCalcParam;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
public class FloorCalcReq {

    // 地板规格
    private String floorSpec;

    // 地板起头方式
    private Integer floorStartWay;

    // 计算地板块数的测量数据
    private  List<FloorCalcParam> calcParams;

}

