package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 客户地板测量数据对象 customer_floor_data
 *
 * @author Chaos
 * @date 2022-03-08
 */
@Data
@TableName(value = "customer_floor_data")
public class CustomerFloorData extends BaseEntity
{
    /** 主键 */
    private Long id;
    /** 客户ID */
    @Excel(name = "客户ID")
    private Long customerId;
    /** 客户信息 */
    @Excel(name = "客户信息")
    private String customerInfo;
    /** 测量长度 */
    @Excel(name = "测量长度")
    private BigDecimal measureLength;
    /** 测量宽度 */
    @Excel(name = "测量宽度")
    private BigDecimal measureWidth;
}
