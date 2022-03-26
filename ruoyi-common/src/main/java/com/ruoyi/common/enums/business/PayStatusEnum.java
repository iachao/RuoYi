package com.ruoyi.common.enums.business;

/**
 * 客户支付状态
 */
public enum PayStatusEnum implements BaseEnum{
    WAIT_PAY(100,"待支付"),
    HAD_PAY_DEPOSIT(120,"已付定金"),
    HAD_PAY_MID_MONEY(200,"已付中期款"),
    COMPLETED(220,"支付完成"),
    CANCEL(500,"已取消")
    ;

    private final Integer key;
    private final String value;

    PayStatusEnum(Integer key,String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public Integer getKey() {
        return key;
    }

    @Override
    public String getValue() {
        return value;
    }


    public static PayStatusEnum getEnumByKey(Integer key) {
        for (PayStatusEnum e : PayStatusEnum.values()) {
            if (e.key == key) {
                return e;
            }
        }
        return null;
    }

    public static boolean compareByKey(Integer key, PayStatusEnum e) {
        if (e == null) {
            return false;
        }
        return Integer.valueOf(e.getKey()).equals(key);
    }
}
