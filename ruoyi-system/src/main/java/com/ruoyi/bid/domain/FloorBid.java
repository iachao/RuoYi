package com.ruoyi.bid.domain;

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
 * 地板报价对象 floor_bid
 *
 * @author Chaos
 * @date 2022-03-26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FloorBid extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;
    /** 品牌 */
    @Excel(name = "品牌")
    private Long supplyId;
    /** 地板类型;1强化地板2实木地板3三层实木地板4多层实木地板5新三层地板6SPC地板 */
    @Excel(name = "地板类型;1强化地板2实木地板3三层实木地板4多层实木地板5新三层地板6SPC地板")
    private Long floorType;
    /** 木种 */
    @Excel(name = "木种")
    private String woodType;
    /** 型号/编号/系列 */
    @Excel(name = "型号/编号/系列")
    private String floorNumber;
    /** 地板规格;1220*168*12*10P */
    @Excel(name = "地板规格;1220*168*12*10P")
    private String floorSpec;
    /** 等级 */
    @Excel(name = "等级")
    private String floorRank;
    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;
    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price3;
    /** 工艺 */
    @Excel(name = "工艺")
    private String technology;
    /** 扣型;1锁扣2平扣 */
    @Excel(name = "扣型;1锁扣2平扣")
    private Long buckleType;
}
