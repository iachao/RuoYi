package com.ruoyi.common.enums.business;

/**
 * 地板订单状态
 */
public enum FloorOrderStatusEnum implements BaseEnum{
    WAIT_SURVEY(100,"待测量"),
    WAIT_SEND(105,"待发货"),
    WAIT_RECEIVED(110,"待收货"),
    WAIT_DELIVER(220,"待送货"),
    WAIT_INSTALL(220,"待安装"),
    COMPLETED(220,"已完工"),
    CANCEL(500,"已取消")
    ;

    private final Integer key;
    private final String value;

    FloorOrderStatusEnum(Integer key, String value) {
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


    public static FloorOrderStatusEnum getEnumByKey(Integer key) {
        for (FloorOrderStatusEnum e : FloorOrderStatusEnum.values()) {
            if (e.key == key) {
                return e;
            }
        }
        return null;
    }

    public static boolean compareByKey(Integer key, FloorOrderStatusEnum e) {
        if (e == null) {
            return false;
        }
        return Integer.valueOf(e.getKey()).equals(key);
    }
}
