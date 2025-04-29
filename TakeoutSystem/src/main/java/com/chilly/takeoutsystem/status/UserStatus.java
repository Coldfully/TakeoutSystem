package com.chilly.takeoutsystem.status;

import lombok.Getter;

@Getter
public enum UserStatus {
    ACTIVE(1), // 活跃
    DISABLED(0); // 禁用

    private final int code;

    UserStatus(int code) {
        this.code = code;
    }

    // 根据代码值获取对应的枚举
    public static UserStatus fromCode(int code) {
        for (UserStatus status : UserStatus.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status code: " + code);
    }
}