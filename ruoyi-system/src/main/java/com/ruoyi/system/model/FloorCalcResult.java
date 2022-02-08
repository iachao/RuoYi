package com.ruoyi.system.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FloorCalcResult {

    // 测量面积
    private BigDecimal measureFloorArea;

    // 需要地板面积
    private BigDecimal installFloorArea;
    // 需要地板块数
    private BigDecimal installFloorBlock;

    // 发货面积
    private BigDecimal sendFloorArea;
    // 发货块数
    private BigDecimal sendFloorBlock;
    // 发货件数
    private BigDecimal sendFloorBox;
}
