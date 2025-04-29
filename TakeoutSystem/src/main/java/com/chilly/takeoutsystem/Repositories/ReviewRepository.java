package com.chilly.takeoutsystem.Repositories;

import com.chilly.takeoutsystem.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 评论仓库接口，用于管理评论数据的增删改查操作。
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    /**
     * 根据订单ID查找评论。
     *
     * @param orderId 订单ID
     * @return 包含评论的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<Review> findByOrder_OrderId(Long orderId);

    /**
     * 根据用户ID查找所有评论。
     *
     * @param userId 用户ID
     * @return 包含评论的列表
     */
    List<Review> findByUser_UserId(Long userId);

    /**
     * 根据商户ID查找所有评论。
     *
     * @param merchantId 商户ID
     * @return 包含评论的列表
     */
    List<Review> findByMerchant_MerchantId(Long merchantId);

    /**
     * 根据用户ID和匿名状态查找评论。
     *
     * @param userId 用户ID
     * @param isAnonymous 匿名状态
     * @return 包含评论的列表
     */
    List<Review> findByUser_UserIdAndIsAnonymous(Long userId, Boolean isAnonymous);

    /**
     * 根据商户ID和匿名状态查找评论。
     *
     * @param merchantId 商户ID
     * @param isAnonymous 匿名状态
     * @return 包含评论的列表
     */
    List<Review> findByMerchant_MerchantIdAndIsAnonymous(Long merchantId, Boolean isAnonymous);
}
