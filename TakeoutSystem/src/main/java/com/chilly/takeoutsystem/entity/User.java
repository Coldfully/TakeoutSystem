package com.chilly.takeoutsystem.entity;

import com.chilly.takeoutsystem.status.UserStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
// 自动生成构造函数
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    // 主键自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 列映射
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username", nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "password_hash", nullable = false)
    // 加密后的密码
    private String passwordHash;

    @Column(name = "phone_number", unique = true, length = 20)
    private String phoneNumber;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 50)
    private String nickname;

    @Column(name = "avatar_url")
    private String avatarUrl;

    // 使用枚举类型来表示状态
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "TINYINT(1) default 1")
    private UserStatus status = UserStatus.ACTIVE;

    @Column(name = "registration_date",
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime registrationDate;

    @Column(name = "last_login_date")
    private LocalDateTime lastLoginDate;

    @Column(name = "created_at",
            nullable = false,
            updatable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "updated_at",
            nullable = false,
            columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime updatedAt;

    // 实现用户和地址的一对多关系
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<UserAddress> addresses;

    // 设置创建时间
    @PrePersist
    protected void onCreate() {
        if (username == null || passwordHash == null) {
            throw new IllegalArgumentException("Username and password hash cannot be null");
        }
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        registrationDate = LocalDateTime.now();
        if (status == null) {
            status = UserStatus.ACTIVE; // 默认状态
        }
    }

    // 设置更新时间
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}