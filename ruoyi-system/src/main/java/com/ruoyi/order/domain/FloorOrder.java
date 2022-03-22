package com.ruoyi.order.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地板订单对象 floor_order
 *
 * @author Chaos
 * @date 2021-12-25
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@TableName(value = "floor_order")
public class FloorOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;
    /** 订单状态;100待测量105待发货110待收货115待送货120待安装200已完成 */
    @Excel(name = "订单状态",dictType = "order_status")
    private Long status;
    /** 客户ID */
    @Excel(name = "客户ID")
    private Long customerId;

    /**
     * 客户信息
     */
    @TableField(exist = false)
    private String customerInfo;

    /** 供应商ID */
    @Excel(name = "供应商",dictType = "floor_supply")
    private Long supplyId;
    /** 供应商名称 */
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
    /** 测量人ID */
    private Long surveyNameId;
    /** 测量人 */
    @Excel(name = "测量人")
    private String surveyName;
    /** 测量面积 */
    @Excel(name = "测量面积")
    private BigDecimal surveyArea;
    /** 测量时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "测量时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date surveyTime;
    /** 现场图片;分号分隔 */
    private String surveyImg;
    /** 发货块数 */
    @Excel(name = "发货块数")
    private Long sendBlock;
    /** 发货面积 */
    @Excel(name = "发货面积")
    private BigDecimal sendArea;
    /** 发货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date sendTime;
    /** 实际使用块数 */
    @Excel(name = "实际使用块数")
    private Long actualUseBlock;
    /** 安装工人ID */
    private Long installNameId;
    /** 安装工人 */
    @Excel(name = "安装工人")
    private String installName;
    /** 安装时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "安装时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date installTime;
    /** 安装面积 */
    @Excel(name = "安装面积")
    private BigDecimal installArea;
    /** 安装图片 */
    @Excel(name = "安装图片")
    private String installImg;
    /** 安装费用 */
    @Excel(name = "安装费用")
    private BigDecimal installAmount;
    /** 单价 */
    private BigDecimal price;
    /** 地板金额 */
    private BigDecimal amount;
}
