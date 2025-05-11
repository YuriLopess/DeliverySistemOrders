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
    @Query("update Pedido p set p.status = :status where p = :pedido")
    void updateStatus(Status status, Order order);

    @Query(value = "SELECT p from Pedido p LEFT JOIN FETCH p.itens where p.id = :id")
    Order forIdWithItem(UUID id);
}
