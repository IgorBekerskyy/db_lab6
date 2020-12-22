package com.bekerskyy.service;

import com.bekerskyy.domain.Order;
import com.bekerskyy.repository.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements AbstractService<Order, Integer> {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public  Order getById(Integer id) {
        return orderRepository.getOne(id);
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Integer id, Order order) {
        if (orderRepository.findById(id).isPresent()) {
            return orderRepository.save(order);
        } else {
            return null;
        }
    }

    @Override
    public void deleteById(Integer id) {
        if (orderRepository.findById(id).isPresent()) {
            orderRepository.deleteById(id);
        }
    }
}

