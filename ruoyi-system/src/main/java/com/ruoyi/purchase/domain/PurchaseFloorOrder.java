package com.ruoyi.purchase.domain;

import java.math.BigDecimal;
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
 * 采购木地板对象 purchase_floor_order
 *
 * @author Chaos
 * @date 2022-03-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PurchaseFloorOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;
    /** 客户ID */
    @Excel(name = "客户ID")
    private Long customerId;
    /** 客户信息 */
    @Excel(name = "客户信息")
    private String customerInfo;
    /** 供应商ID */
    @Excel(name = "供应商ID")
    private Long supplyId;
    /** 供应商名称 */
    @Excel(name = "供应商名称")
    private String supplyName;
    /** 地板类型;1强化地板2实木地板3三层实木地板4多层实木地板5新三层地板6SPC地板 */
    @Excel(name = "地板类型;1强化地板2实木地板3三层实木地板4多层实木地板5新三层地板6SPC地板")
    private Long floorType;
    /** 地板规格;1220*168*12*10P */
    @Excel(name = "地板规格;1220*168*12*10P")
    private String floorSpec;
    /** 地板型号;PR882 */
    @Excel(name = "地板型号;PR882")
    private String floorNumber;
    /** 采购块数 */
    @Excel(name = "采购块数")
    private Long purchaseBlock;
    /** 采购面积 */
    @Excel(name = "采购面积")
    private BigDecimal purchaseArea;
    /** 每平方单价 */
    @Excel(name = "每平方单价")
    private BigDecimal singPrice;
    /** 采购状态;100待审核120已发货200已到货220已送货500已取消 */
    @Excel(name = "采购状态;100待审核120已发货200已到货220已送货500已取消")
    private Long status;
    /** 采购金额 */
    @Excel(name = "采购金额")
    private BigDecimal purchaseAmount;
}
