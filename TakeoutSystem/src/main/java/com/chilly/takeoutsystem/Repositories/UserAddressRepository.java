package com.chilly.takeoutsystem.Repositories;

import com.chilly.takeoutsystem.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 用户地址仓库接口，用于管理用户地址数据的增删改查操作。
 */
@Repository
public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    /**
     * 根据用户ID查找所有地址。
     *
     * @param userId 用户ID
     * @return 包含用户地址的列表
     */
    List<UserAddress> findByUserId(Long userId);

    /**
     * 根据用户ID和默认地址标志查找地址。
     *
     * @param userId 用户ID
     * @param isDefault 是否为默认地址
     * @return 包含用户的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<UserAddress> findByUserIdAndIsDefault(Long userId, Boolean isDefault);

    /**
     * 检查用户ID和收件人姓名是否已存在。
     *
     * @param userId 用户ID
     * @param recipientName 收件人姓名
     * @return 如果已存在返回 true，否则返回 false
     */
    boolean existsByUserIdAndRecipientName(Long userId, String recipientName);

    /**
     * 检查用户ID和手机号是否已存在。
     *
     * @param userId 用户ID
     * @param phoneNumber 手机号
     * @return 如果已存在返回 true，否则返回 false
     */
    boolean existsByUserIdAndPhoneNumber(Long userId, String phoneNumber);

    /**
     * 检查用户ID和街道地址是否已存在。
     *
     * @param userId 用户ID
     * @param streetAddress 街道地址
     * @return 如果已存在返回 true，否则返回 false
     */
    boolean existsByUserIdAndStreetAddress(Long userId, String streetAddress);
}
