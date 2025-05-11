package io.github.YuriLopess.DeliverySystemOrders.dto;

import io.github.YuriLopess.DeliverySystemOrders.model.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StatusDTO {

    private Status status;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public StatusDTO(Status status) {
        this.status = status;
    }
}