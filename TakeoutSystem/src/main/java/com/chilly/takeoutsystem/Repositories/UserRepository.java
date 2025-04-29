package com.chilly.takeoutsystem.Repositories;

import com.chilly.takeoutsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * 用户仓库接口，用于管理用户数据的增删改查操作。
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * 根据用户名查找用户。
     *
     * @param username 用户名
     * @return 包含用户的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<User> findByUsername(String username);

    /**
     * 根据手机号查找用户。
     *
     * @param phoneNumber 手机号
     * @return 包含用户的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<User> findByPhoneNumber(String phoneNumber);

    /**
     * 根据邮箱地址查找用户。
     *
     * @param email 邮箱地址
     * @return 包含用户的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<User> findByEmail(String email);

    /**
     * 检查用户名是否已存在。
     *
     * @param username 用户名
     * @return 如果用户名已存在返回 true，否则返回 false
     */
    boolean existsByUsername(String username);

    /**
     * 检查手机号是否已存在。
     *
     * @param phoneNumber 手机号
     * @return 如果手机号已存在返回 true，否则返回 false
     */
    boolean existsByPhoneNumber(String phoneNumber);

    /**
     * 检查邮箱地址是否已存在。
     *
     * @param email 邮箱地址
     * @return 如果邮箱地址已存在返回 true，否则返回 false
     */
    boolean existsByEmail(String email);
}
