package com.ruoyi.order.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 踢脚线订单对象 foot_line_order
 *
 * @author Chaos
 * @date 2022-04-23
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class FootLineOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;
    /** 订单状态;100待测量105待发货110待收货115待送货120待安装200已完成 */
    @Excel(name = "订单状态;100待测量105待发货110待收货115待送货120待安装200已完成")
    private Long status;
    /** 客户ID */
    @Excel(name = "客户ID")
    private Long customerId;
    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplyId;
    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplyName;
    /** 脚线型号 */
    @Excel(name = "脚线型号")
    private String footNumber;
    /** 测量米数 */
    @Excel(name = "测量米数")
    private Long surveyArea;
    /** 发货米数 */
    @Excel(name = "发货米数")
    private Long sendBlock;
    /** 实际使用米数 */
    @Excel(name = "实际使用米数")
    private Long actualUseBlock;
    /** 测量人ID */
    @Excel(name = "测量人ID")
    private Long surveyNameId;
    /** 测量人 */
    @Excel(name = "测量人")
    private String surveyName;
    /** 测量时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "测量时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date surveyTime;
    /** 现场图片;分号分隔 */
    @Excel(name = "现场图片;分号分隔")
    private String surveyImg;
    /** 安装工人ID */
    @Excel(name = "安装工人ID")
    private Long installNameId;
    /** 安装工人 */
    @Excel(name = "安装工人")
    private String installName;
    /** 安装时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "安装时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date installTime;
    /** 安装图片 */
    @Excel(name = "安装图片")
    private String installImg;
    /** 安装费 */
    @Excel(name = "安装费")
    private BigDecimal installAmount;
    /** 单价/米 */
    @Excel(name = "单价/米")
    private BigDecimal price;
    /** 脚线金额 */
    @Excel(name = "脚线金额")
    private BigDecimal amount;

    /**
     * 客户信息
     */
    @TableField(exist = false)
    private String customerInfo;
}
