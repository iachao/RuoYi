package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户对象 customer_order
 * 
 * @author Chaos
 * @date 2021-12-18
 */
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
    @Excel(name = "选购品类;1木地板2墙饰壁纸壁布3脚线4实木整梯5实木包梯6钢木整梯7木地板包梯8电动楼梯9玻璃扶手11小柱扶手12护墙板13衣柜14橱柜15木门16窗套垭口17格栅18其它88整体装修")
    private String buyCategories;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private BigDecimal amount;

    /** 支付状态;100待支付110已付定金120已付中期款200支付完成 */
    @Excel(name = "支付状态;100待支付110已付定金120已付中期款200支付完成")
    private Long payStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSalepersonId(Long salepersonId) 
    {
        this.salepersonId = salepersonId;
    }

    public Long getSalepersonId() 
    {
        return salepersonId;
    }
    public void setSalepersonName(String salepersonName) 
    {
        this.salepersonName = salepersonName;
    }

    public String getSalepersonName() 
    {
        return salepersonName;
    }
    public void setCustomerSource(Long customerSource) 
    {
        this.customerSource = customerSource;
    }

    public Long getCustomerSource() 
    {
        return customerSource;
    }
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public String getCustomerName() 
    {
        return customerName;
    }
    public void setCustomerPhone(String customerPhone) 
    {
        this.customerPhone = customerPhone;
    }

    public String getCustomerPhone() 
    {
        return customerPhone;
    }
    public void setResponsiblePerson(String responsiblePerson) 
    {
        this.responsiblePerson = responsiblePerson;
    }

    public String getResponsiblePerson() 
    {
        return responsiblePerson;
    }
    public void setResponsiblePhone(String responsiblePhone) 
    {
        this.responsiblePhone = responsiblePhone;
    }

    public String getResponsiblePhone() 
    {
        return responsiblePhone;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setDistrict(String district) 
    {
        this.district = district;
    }

    public String getDistrict() 
    {
        return district;
    }
    public void setTown(String town) 
    {
        this.town = town;
    }

    public String getTown() 
    {
        return town;
    }
    public void setCommunity(String community) 
    {
        this.community = community;
    }

    public String getCommunity() 
    {
        return community;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setOtherContactName(String otherContactName) 
    {
        this.otherContactName = otherContactName;
    }

    public String getOtherContactName() 
    {
        return otherContactName;
    }
    public void setOtherContactPhone(String otherContactPhone) 
    {
        this.otherContactPhone = otherContactPhone;
    }

    public String getOtherContactPhone() 
    {
        return otherContactPhone;
    }
    public void setBuyCategories(String buyCategories) 
    {
        this.buyCategories = buyCategories;
    }

    public String getBuyCategories() 
    {
        return buyCategories;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setPayStatus(Long payStatus) 
    {
        this.payStatus = payStatus;
    }

    public Long getPayStatus() 
    {
        return payStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("salepersonId", getSalepersonId())
            .append("salepersonName", getSalepersonName())
            .append("customerSource", getCustomerSource())
            .append("customerName", getCustomerName())
            .append("customerPhone", getCustomerPhone())
            .append("responsiblePerson", getResponsiblePerson())
            .append("responsiblePhone", getResponsiblePhone())
            .append("province", getProvince())
            .append("city", getCity())
            .append("district", getDistrict())
            .append("town", getTown())
            .append("community", getCommunity())
            .append("address", getAddress())
            .append("otherContactName", getOtherContactName())
            .append("otherContactPhone", getOtherContactPhone())
            .append("buyCategories", getBuyCategories())
            .append("memo", getMemo())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("amount", getAmount())
            .append("payStatus", getPayStatus())
            .toString();
    }
}
