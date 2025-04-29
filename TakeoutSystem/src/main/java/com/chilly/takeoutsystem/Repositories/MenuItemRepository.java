package com.chilly.takeoutsystem.Repositories;

import com.chilly.takeoutsystem.entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 菜单项仓库接口，用于管理菜单项数据的增删改查操作。
 */
@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {

    /**
     * 根据商户ID查找所有菜单项。
     *
     * @param merchantId 商户ID
     * @return 包含菜单项的列表
     */
    List<MenuItem> findByMerchantId(Long merchantId);

    /**
     * 根据商户ID和菜单项名称查找菜单项。
     *
     * @param merchantId 商户ID
     * @param name 菜单项名称
     * @return 包含菜单项的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<MenuItem> findByMerchantIdAndName(Long merchantId, String name);

    /**
     * 根据商户ID和是否可用查找菜单项。
     *
     * @param merchantId 商户ID
     * @param isAvailable 是否可用
     * @return 包含菜单项的列表
     */
    List<MenuItem> findByMerchantIdAndIsAvailable(Long merchantId, Boolean isAvailable);

    /**
     * 检查商户ID和菜单项名称是否已存在。
     *
     * @param merchantId 商户ID
     * @param name 菜单项名称
     * @return 如果已存在返回 true，否则返回 false
     */
    boolean existsByMerchantIdAndName(Long merchantId, String name);

    /**
     * 根据商户ID和菜单项类别查找菜单项。
     *
     * @param merchantId 商户ID
     * @param category 菜单项类别
     * @return 包含菜单项的列表
     */
    List<MenuItem> findByMerchantIdAndCategory(Long merchantId, String category);
}
