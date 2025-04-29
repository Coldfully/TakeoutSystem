package com.chilly.takeoutsystem.Repositories;

import com.chilly.takeoutsystem.entity.ReviewItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 评论项仓库接口，用于管理评论项数据的增删改查操作。
 */
@Repository
public interface ReviewItemRepository extends JpaRepository<ReviewItem, Long> {

    /**
     * 根据评论ID查找所有评论项。
     *
     * @param reviewId 评论ID
     * @return 包含评论项的列表
     */
    List<ReviewItem> findByReview_ReviewId(Long reviewId);

    /**
     * 根据订单项ID查找所有评论项。
     *
     * @param orderItemId 订单项ID
     * @return 包含评论项的列表
     */
    List<ReviewItem> findByOrderItem_OrderItemId(Long orderItemId);

    /**
     * 根据菜单项ID查找所有评论项。
     *
     * @param itemId 菜单项ID
     * @return 包含评论项的列表
     */
    List<ReviewItem> findByMenuItem_ItemId(Long itemId);

    /**
     * 根据评论ID和菜单项ID查找评论项。
     *
     * @param reviewId 评论ID
     * @param itemId 菜单项ID
     * @return 包含评论项的 Optional 对象，如果不存在则返回空 Optional
     */
    Optional<ReviewItem> findByReview_ReviewIdAndMenuItem_ItemId(Long reviewId, Long itemId);
}
