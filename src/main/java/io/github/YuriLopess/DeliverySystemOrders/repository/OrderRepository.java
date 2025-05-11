package io.github.YuriLopess.DeliverySystemOrders.repository;

import io.github.YuriLopess.DeliverySystemOrders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
