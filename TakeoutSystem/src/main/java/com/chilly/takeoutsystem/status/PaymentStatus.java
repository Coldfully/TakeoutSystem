package com.chilly.takeoutsystem.status;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    // 0: 未支付, 1: 已支付, 2: 退款中, 3: 已退款
    DISABLED(0),
    ACTIVE(1),
    REST(2),
    REFUND(3);

    private final int code;

    PaymentStatus(int code) {
        this.code = code;
    }

    // 根据代码值获取对应的枚举
    public static PaymentStatus fromCode(int code) {
        for (PaymentStatus status : PaymentStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }
}