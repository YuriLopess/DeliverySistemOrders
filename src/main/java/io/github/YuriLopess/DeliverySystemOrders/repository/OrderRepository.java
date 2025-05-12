package io.github.YuriLopess.DeliverySystemOrders.repository;

import io.github.YuriLopess.DeliverySystemOrders.model.Order;
import io.github.YuriLopess.DeliverySystemOrders.model.Status;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update Order o set o.status = :status where o = :order")
    void updateStatus(Status status, Order order);

    @Query("SELECT o from Order o LEFT JOIN FETCH o.items where o.id = :id")
    Order forIdWithItem(UUID id);
}
