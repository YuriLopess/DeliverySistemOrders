package io.github.YuriLopess.DeliverySystemOrders.dto;

import io.github.YuriLopess.DeliverySystemOrders.model.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderDTO {

    private UUID id;
    private LocalDateTime dateTime;
    private Status status;
    private List<OrderItemDTO> items = new ArrayList<>();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }

    public OrderDTO(UUID id, LocalDateTime dateTime, Status status, List<OrderItemDTO> items) {
        this.id = id;
        this.dateTime = dateTime;
        this.status = status;
        this.items = items;
    }
}
