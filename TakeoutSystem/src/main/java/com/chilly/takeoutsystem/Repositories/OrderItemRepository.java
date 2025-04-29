package com.chilly.takeoutsystem.Repositories;

import com.chilly.takeoutsystem.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 订单项仓库接口，用于管理订单项数据的增删改查操作。
 */
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    /**
     * 根据订单ID查找所有订单项。
     *
     * @param orderId 订单ID
     * @return 包含订单项的列表
     */
    List<OrderItem> findByOrderId(Long orderId);

    /**
     * 根据菜单项ID查找所有订单项。
     *
     * @param itemId 菜单项ID
     * @return 包含订单项的列表
     */
    List<OrderItem> findByItemId(Long itemId);

    /**
     * 根据订单ID和菜单项ID查找订单项。
     *
     * @param orderId 订单ID
     * @param itemId 菜单项ID
     * @return 包含订单项的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<OrderItem> findByOrderIdAndItemId(Long orderId, Long itemId);
}
