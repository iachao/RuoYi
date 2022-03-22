package com.ruoyi.order.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 用户输入的房租面积计算参数
 */
@Data
public class FloorCalcParam {

    // 长 mm
    private BigDecimal measureLength = BigDecimal.ZERO;
    // 宽 mm
    private BigDecimal measureWidth = BigDecimal.ZERO;

    // 优化后 长mm
    private BigDecimal optimizeLength;
    // 优化后 宽mm
    private BigDecimal optimizeWidth;

    private FloorCalcResult floorCalcResult;
}
