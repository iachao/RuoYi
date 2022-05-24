package com.ruoyi.order.model;

import lombok.*;

import java.math.BigDecimal;

/**
 * 地板规格参数
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FloorParam {

    // 地板长度
    private BigDecimal floorLength;
    // 地板宽度
    private BigDecimal floorWidth;
    // 地板厚度
    private BigDecimal floorThickness;
    // 每箱地板数量
    private BigDecimal floorBlockPerBox;

    // 地板左边是否切开
    private Boolean leftFloorCut = false;
    // 地板右边是否切开
    private Boolean rightFloorCut = false;
    // 地板上边是否切开
    private Boolean topFloorCut = false;
    // 地板下边是否切开
    private Boolean bottomFloorCut = false;
}
