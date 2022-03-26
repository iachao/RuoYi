package com.ruoyi.common.enums.business;

/**
 * 采购状态
 */
public enum PurchaseStatusEnum implements BaseEnum {

    WAIT_AUDIT(100,"待审核"),
    HAD_SEND(120,"已发货"),
    RECEIVED(200,"已到货"),
    HAD_DELIVER(220,"已送货"),
    CANCEL(500,"已取消")
    ;

    private final Integer key;
    private final String value;

    PurchaseStatusEnum(Integer key, String value) {
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


    public static PurchaseStatusEnum getEnumByKey(Integer key) {
        for (PurchaseStatusEnum e : PurchaseStatusEnum.values()) {
            if (e.key == key) {
                return e;
            }
        }
        return null;
    }

    public static boolean compareByKey(Integer key, PurchaseStatusEnum e) {
        if (e == null) {
            return false;
        }
        return Integer.valueOf(e.getKey()).equals(key);
    }
}
