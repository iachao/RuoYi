package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 地板库存对象 stock_floor
 * 
 * @author Chaos
 * @date 2021-12-18
 */
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
    @Excel(name = "地板类型;1强化地板2实木地板3三层实木地板4多层实木地板5新三层地板6SPC地板")
    private Long floorType;

    /** 地板规格;1220*168*12*10P */
    @Excel(name = "地板规格;1220*168*12*10P")
    private String floorSpec;

    /** 地板型号;PR882 */
    @Excel(name = "地板型号;PR882")
    private String floorNumber;

    /** 库存 */
    @Excel(name = "库存")
    private Long stockCount;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSupplyId(Long supplyId) 
    {
        this.supplyId = supplyId;
    }

    public Long getSupplyId() 
    {
        return supplyId;
    }
    public void setSupplyName(String supplyName) 
    {
        this.supplyName = supplyName;
    }

    public String getSupplyName() 
    {
        return supplyName;
    }
    public void setFloorType(Long floorType) 
    {
        this.floorType = floorType;
    }

    public Long getFloorType() 
    {
        return floorType;
    }
    public void setFloorSpec(String floorSpec) 
    {
        this.floorSpec = floorSpec;
    }

    public String getFloorSpec() 
    {
        return floorSpec;
    }
    public void setFloorNumber(String floorNumber) 
    {
        this.floorNumber = floorNumber;
    }

    public String getFloorNumber() 
    {
        return floorNumber;
    }
    public void setStockCount(Long stockCount) 
    {
        this.stockCount = stockCount;
    }

    public Long getStockCount() 
    {
        return stockCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("supplyId", getSupplyId())
            .append("supplyName", getSupplyName())
            .append("floorType", getFloorType())
            .append("floorSpec", getFloorSpec())
            .append("floorNumber", getFloorNumber())
            .append("stockCount", getStockCount())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
