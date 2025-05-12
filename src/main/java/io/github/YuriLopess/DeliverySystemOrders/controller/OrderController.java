package io.github.YuriLopess.DeliverySystemOrders.controller;

import io.github.YuriLopess.DeliverySystemOrders.dto.OrderDTO;
import io.github.YuriLopess.DeliverySystemOrders.dto.StatusDTO;
import io.github.YuriLopess.DeliverySystemOrders.service.OrderService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @GetMapping()
    public List<OrderDTO> listAll() {
        return service.GetAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> listById(@PathVariable @NotNull UUID id) {
        OrderDTO dto = service.GetById(id);

        return  ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody @Valid OrderDTO dto, UriComponentsBuilder uriBuilder) {
        OrderDTO orderPlaced = service.createOrder(dto);

        URI addres = uriBuilder.path("/orders/{id}").buildAndExpand(orderPlaced.getId()).toUri();

        return ResponseEntity.created(addres).body(orderPlaced);

    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrderDTO> updateStatus(@PathVariable UUID id, @RequestBody StatusDTO status){
        OrderDTO dto = service.updateOrder(id, status);

        return ResponseEntity.ok(dto);
    }


    @PutMapping("/{id}/pago")
    public ResponseEntity<Void> approvePayment(@PathVariable @NotNull UUID id) {
        service.approvePaymentOrder(id);

        return ResponseEntity.ok().build();

    }
}
