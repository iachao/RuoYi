package com.ruoyi.order.req;

import com.ruoyi.order.model.FloorCalcParam;
import lombok.Data;

import java.util.List;

@Data
public class FloorCalcReq {

    private Long customerId;
    private String customerInfo;

    // 地板规格
    private String floorSpec;

    // 地板起头方式
    private Integer floorStartWay;

    // 计算地板块数的测量数据
    private  List<FloorCalcParam> calcParams;

}

