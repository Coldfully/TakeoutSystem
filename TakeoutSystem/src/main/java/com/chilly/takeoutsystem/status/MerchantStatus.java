package com.chilly.takeoutsystem.status;

import lombok.Getter;

@Getter
public enum MerchantStatus {
    ACTIVE(1), // 活跃
    REST(2),  // 休息
    DISABLED(0); // 禁用

    private final int code;

    MerchantStatus(int code) {
        this.code = code;
    }

    // 根据代码值获取对应的枚举
    public static MerchantStatus fromCode(int code) {
        for (MerchantStatus status : MerchantStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }
}