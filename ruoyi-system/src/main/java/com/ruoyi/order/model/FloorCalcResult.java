package com.ruoyi.order.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * 某面积计算地板结果
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FloorCalcResult {

    // 测量面积
    private BigDecimal measureFloorArea = BigDecimal.ZERO;

    // 需要地板面积
    private BigDecimal installFloorArea = BigDecimal.ZERO;
    // 需要地板块数
    private BigDecimal installFloorBlock = BigDecimal.ZERO;

    // 发货面积
    private BigDecimal sendFloorArea = BigDecimal.ZERO;
    // 发货块数
    private BigDecimal sendFloorBlock = BigDecimal.ZERO;
    // 发货件数
    private BigDecimal sendFloorBox = BigDecimal.ZERO;
}