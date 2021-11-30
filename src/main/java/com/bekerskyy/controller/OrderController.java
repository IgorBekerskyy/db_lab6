package com.bekerskyy.controller;
import com.bekerskyy.domain.Order;
import com.bekerskyy.dto.OrderDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bekerskyy.service.OrderService;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/Order")
@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<OrderDto>> getAll() {
        List<Order> orders  = orderService.getAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = new OrderDto(
                    order.getId(),
                    order.getClient_id(),
                    order.getSalon_id(),
                    order.getPackaging_id(),
                    order.getDelivery_in_days(),
                    order.getGood_id()
            );
            orderDtos.add(orderDto);
        }
        return new ResponseEntity<>(orderDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<OrderDto> getById(@PathVariable Integer id) {
        Order order = orderService.getById(id);
        if (order != null) {
            OrderDto orderDto = new OrderDto(
                    order.getId(),
                    order.getClient_id(),
                    order.getSalon_id(),
                    order.getPackaging_id(),
                    order.getDelivery_in_days(),
                    order.getGood_id()
            );
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Order newOrder) {
        orderService.create(newOrder);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT,
            value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<OrderDto> update(@PathVariable Integer id,
                                          @RequestBody Order order) {
        Order order1 = orderService.getById(id);
        if (order1 != null) {
            orderService.update(id, order);
            OrderDto orderDto = new OrderDto(
                    order.getId(),
                    order.getClient_id(),
                    order.getSalon_id(),
                    order.getPackaging_id(),
                    order.getDelivery_in_days(),
                    order.getGood_id()
            );
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (orderService.getById(id) != null) {
            orderService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

