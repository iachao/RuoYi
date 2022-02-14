package com.ruoyi.system.model;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;

@Data
public class FloorCalcParam {

    // 长 mm
    private BigDecimal measureLength = BigDecimal.ZERO;
    // 宽 mm
    private BigDecimal measureWidth = BigDecimal.ZERO;

    public boolean isSubtractArea() {
        return this.measureLength.compareTo(BigDecimal.ZERO) != 1 || this.measureWidth.compareTo(BigDecimal.ZERO) != 1;
    }

    // 是否减去该面积
    private boolean subtractArea = false;

    // 优化后 长mm
    private BigDecimal optimizeLength;
    // 优化后 宽mm
    private BigDecimal optimizeWidth;
}
