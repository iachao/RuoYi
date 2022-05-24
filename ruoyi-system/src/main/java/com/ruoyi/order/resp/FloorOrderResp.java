package com.ruoyi.order.resp;

import com.ruoyi.order.domain.FloorOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FloorOrderResp extends FloorOrder {

    private String customerSource;

    private String customerName;

    private String customerPhone;

    private String community;

    private String address;
}
