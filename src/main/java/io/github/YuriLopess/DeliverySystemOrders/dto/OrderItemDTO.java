package io.github.YuriLopess.DeliverySystemOrders.dto;

import java.util.UUID;

public class OrderItemDTO {

    private UUID id;
    private Integer quantity;
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderItemDTO(UUID id, Integer quantity, String description) {
        this.id = id;
        this.quantity = quantity;
        this.description = description;
    }
}
