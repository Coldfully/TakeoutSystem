package com.chilly.takeoutsystem.Repositories;

import com.chilly.takeoutsystem.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 购物车项仓库接口，用于管理购物车项数据的增删改查操作。
 */
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    /**
     * 根据用户ID查找所有购物车项。
     *
     * @param userId 用户ID
     * @return 包含购物车项的列表
     */
    List<CartItem> findByUserId(Long userId);

    /**
     * 根据商户ID查找所有购物车项。
     *
     * @param merchantId 商户ID
     * @return 包含购物车项的列表
     */
    List<CartItem> findByMerchantId(Long merchantId);

    /**
     * 根据用户ID和菜单项ID查找购物车项。
     *
     * @param userId 用户ID
     * @param itemId 菜单项ID
     * @return 包含购物车项的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<CartItem> findByUserIdAndItemId(Long userId, Long itemId);
}
