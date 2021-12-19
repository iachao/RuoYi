package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 客户对象 customer_order
 * 
 * @author Chaos
 * @date 2021-12-18
 */
@Data
@TableName(value = "customer_name")
public class CustomerOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 销售员id */
    private Long salepersonId;

    /** 销售员名称 */
    @Excel(name = "销售员名称")
    private String salepersonName;

    /** 客户来源;1店内订单2装修公司3设计师带单4工长带单5亲戚朋友6老客户介绍7其它 */
    @Excel(name = "客户来源;1店内订单2装修公司3设计师带单4工长带单5亲戚朋友6老客户介绍7其它")
    private Long customerSource;

    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String customerPhone;

    /** 客户负责人名称 */
    @Excel(name = "客户负责人名称")
    private String responsiblePerson;

    /** 客户负责人联系方式 */
    @Excel(name = "客户负责人联系方式")
    private String responsiblePhone;

    /** 省 */
    private String province;

    /** 市 */
    private String city;

    /** 县区 */
    private String district;

    /** 镇 */
    private String town;

    /** 小区 */
    @Excel(name = "小区")
    private String community;

    /** 楼牌号 */
    @Excel(name = "楼牌号")
    private String address;

    /** 其它联系人 */
    @Excel(name = "其它联系人")
    private String otherContactName;

    /** 其它联系人联系电话 */
    @Excel(name = "其它联系人联系电话")
    private String otherContactPhone;

    /** 选购品类;1木地板2墙饰壁纸壁布3脚线4实木整梯5实木包梯6钢木整梯7木地板包梯8电动楼梯9玻璃扶手11小柱扶手12护墙板13衣柜14橱柜15木门16窗套垭口17格栅18其它88整体装修 */
    @Excel(name = "选购品类")
    private String buyCategories;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private BigDecimal amount;

    /** 支付状态;100待支付110已付定金120已付中期款200支付完成 */
    @Excel(name = "支付状态")
    private Long payStatus;

    @TableLogic
    private Integer deleted;
}
