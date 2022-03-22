package com.ruoyi.customer.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 客户售后服务对象 customer_after_sale
 *
 * @author Chaos
 * @date 2022-03-22
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class CustomerAfterSale extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;
    /** 客户ID */
    private Long customerId;
    /** 客户名称 */
    @Excel(name = "客户名称")
    private String customerName;
    /** 联系电话 */
    @Excel(name = "联系电话")
    private String customerPhone;
    /** 小区 */
    @Excel(name = "小区")
    private String community;
    /** 楼牌号 */
    @Excel(name = "楼牌号")
    private String address;
    /** 购买时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购买时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date buyTime;
    /** 同购买品类 */
    @Excel(name = "同购买品类")
    private String issueCategories;
    /** 问题描述 */
    @Excel(name = "问题描述")
    private String issueDesc;
    /** 处理人 */
    @Excel(name = "处理人")
    private String dealBy;
    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dealTime;
    /** 处理结果 */
    @Excel(name = "处理结果")
    private String dealResult;
    /** 服务状态;100待处理120服务中150部分处理200已处理500已取消 */
    @Excel(name = "服务状态;100待处理120服务中150部分处理200已处理500已取消")
    private Long dealStatus;
    /** 是否删除 */
    @Excel(name = "是否删除")
    @TableLogic
    private Long deleted;
}
