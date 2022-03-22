package com.ruoyi.order.resp;

import com.ruoyi.order.domain.CustomerOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerOrderResp extends CustomerOrder {

    private String customerInfo;

    public String getCustomerInfo() {

        List<String> info = new ArrayList<>();
        info.add(this.getCustomerName());
        info.add(this.getCustomerPhone());
        info.add(this.getCommunity());
        info.add(this.getAddress());
        return String.join(",",info);
    }
}
