package com.chilly.takeoutsystem.Repositories;

import com.chilly.takeoutsystem.entity.Order;
import com.chilly.takeoutsystem.status.OrderStatus;
import com.chilly.takeoutsystem.status.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 订单仓库接口，用于管理订单数据的增删改查操作。
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    /**
     * 根据用户ID查找所有订单。
     *
     * @param userId 用户ID
     * @return 包含订单的列表
     */
    List<Order> findByUserId(Long userId);

    /**
     * 根据商户ID查找所有订单。
     *
     * @param merchantId 商户ID
     * @return 包含订单的列表
     */
    List<Order> findByMerchantId(Long merchantId);

    /**
     * 根据订单号查找订单。
     *
     * @param orderSn 订单号
     * @return 包含订单的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<Order> findByOrderSn(String orderSn);

    /**
     * 根据用户ID和订单状态查找订单。
     *
     * @param userId 用户ID
     * @param orderStatus 订单状态
     * @return 包含订单的列表
     */
    List<Order> findByUserIdAndOrderStatus(Long userId, OrderStatus orderStatus);

    /**
     * 根据商户ID和订单状态查找订单。
     *
     * @param merchantId 商户ID
     * @param orderStatus 订单状态
     * @return 包含订单的列表
     */
    List<Order> findByMerchantIdAndOrderStatus(Long merchantId, OrderStatus orderStatus);

    /**
     * 根据用户ID和支付状态查找订单。
     *
     * @param userId 用户ID
     * @param paymentStatus 支付状态
     * @return 包含订单的列表
     */
    List<Order> findByUserIdAndPaymentStatus(Long userId, PaymentStatus paymentStatus);

    /**
     * 根据商户ID和支付状态查找订单。
     *
     * @param merchantId 商户ID
     * @param paymentStatus 支付状态
     * @return 包含订单的列表
     */
    List<Order> findByMerchantIdAndPaymentStatus(Long merchantId, PaymentStatus paymentStatus);
}
