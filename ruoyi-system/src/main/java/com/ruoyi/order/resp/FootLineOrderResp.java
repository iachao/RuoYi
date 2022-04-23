package com.ruoyi.order.resp;

import com.ruoyi.order.domain.FloorOrder;
import com.ruoyi.order.domain.FootLineOrder;
import lombok.Data;

@Data
public class FootLineOrderResp extends FootLineOrder {

    private String customerSource;

    private String customerName;

    private String customerPhone;

    private String community;

    private String address;
}
