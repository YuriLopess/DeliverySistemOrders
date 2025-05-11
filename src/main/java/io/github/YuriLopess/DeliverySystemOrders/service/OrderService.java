package io.github.YuriLopess.DeliverySystemOrders.service;

import io.github.YuriLopess.DeliverySystemOrders.dto.OrderDTO;
import io.github.YuriLopess.DeliverySystemOrders.dto.StatusDTO;
import io.github.YuriLopess.DeliverySystemOrders.model.Order;
import io.github.YuriLopess.DeliverySystemOrders.model.Status;
import io.github.YuriLopess.DeliverySystemOrders.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;
import org.aspectj.weaver.ast.Or;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private final ModelMapper modelMapper;

    public OrderService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<OrderDTO> GetAll() {
        return repository.findAll().stream()
                .map(p -> modelMapper.map(p, OrderDTO.class))
                .collect(Collectors.toList());
    }

    public OrderDTO GetById(UUID id) {
        Order order = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return modelMapper.map(order, OrderDTO.class);
    }

    public OrderDTO createOrder(OrderDTO dto) {
        Order order = modelMapper.map(dto, Order.class);

        order.setDateTime(LocalDateTime.now());
        order.setStatus(Status.COMPLETED);
        order.getItems().forEach(item -> item.setOrder(order));
        Order salvo = repository.save(order);

        return modelMapper.map(order, OrderDTO.class);
    }

    public OrderDTO updateOrder(UUID id, StatusDTO dto) {

        Order order = repository.forIdWithItem(id);

        if (order == null) {
            throw new EntityNotFoundException();
        }

        order.setStatus(dto.getStatus());
        repository.updateStatus(dto.getStatus(), order);
        return modelMapper.map(order, OrderDTO.class);
    }

    public void approvePaymentOrder(UUID id) {

        Order order = repository.forIdWithItem(id);

        if (order == null) {
            throw new EntityNotFoundException();
        }

        order.setStatus(Status.PAID);
        repository.updateStatus(Status.PAID, order);
    }
}