package com.chilly.takeoutsystem.Repositories;

import com.chilly.takeoutsystem.entity.Merchant;
import com.chilly.takeoutsystem.status.MerchantStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 商户仓库接口，用于管理商户数据的增删改查操作。
 */
@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {

    /**
     * 根据商户名称查找商户。
     *
     * @param name 商户名称
     * @return 包含商户的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<Merchant> findByName(String name);

    /**
     * 根据商户状态查找所有商户。
     *
     * @param status 商户状态
     * @return 包含商户的列表
     */
    List<Merchant> findByStatus(MerchantStatus status);

    /**
     * 检查商户名称是否已存在。
     *
     * @param name 商户名称
     * @return 如果已存在返回 true，否则返回 false
     */
    boolean existsByName(String name);

    /**
     * 检查商户手机号是否已存在。
     *
     * @param phoneNumber 商户手机号
     * @return 如果已存在返回 true，否则返回 false
     */
    boolean existsByPhoneNumber(String phoneNumber);
}