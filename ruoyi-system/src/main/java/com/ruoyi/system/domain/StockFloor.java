package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 地板库存对象 stock_floor
 * 
 * @author Chaos
 * @date 2021-12-18
 */
@Data
@TableName(value = "stock_floor")
public class StockFloor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplyId;

    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplyName;

    /** 地板类型;1强化地板2实木地板3三层实木地板4多层实木地板5新三层地板6SPC地板 */
    @Excel(name = "地板类型",dictType = "floor_type")
    private Long floorType;

    /** 地板规格;1220*168*12*10P */
    @Excel(name = "地板规格",dictType = "floor_spec")
    private String floorSpec;

    /** 地板型号;PR882 */
    @Excel(name = "地板型号")
    private String floorNumber;

    /** 库存 */
    @Excel(name = "库存(块)")
    private Long stockCount;

    @Excel(name = "库存面积")
    private BigDecimal floorArea;

    @TableLogic
    private Integer deleted;
}
