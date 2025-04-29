package com.chilly.takeoutsystem.status;

import lombok.Getter;

@Getter
public enum OrderStatus {
    // 0: 待支付, 1: 待接单, 2: 制作中, 3: 待配送, 4: 配送中, 5: 已完成, 6: 已取消, 7: 异常
    PENDING_PAYMENT(0),
    PENDING_ORDER(1),
    MAKING(2),
    PENDING_DELIVERY(3),
    DELIVERING(4),
    COMPLETED(5),
    CANCELLED(6),
    EXCEPTION(7);

    private final int code;

    OrderStatus(int code) {
        this.code = code;
    }

    // 根据代码值获取对应的枚举
    public static OrderStatus fromCode(int code) {
        for (OrderStatus status : OrderStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }
}