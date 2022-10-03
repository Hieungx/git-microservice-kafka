package com.nthieu.orderservice.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.nthieu.orderservice.dto.OrderDTO;
import com.nthieu.orderservice.dto.OrderEventDTO;
import com.nthieu.orderservice.kafka.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hieungx
 * 28/09/2022
 **/
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderProducer orderProducer;

    @PostMapping
    public String placeOrder(@RequestBody OrderDTO order) throws JsonProcessingException {
        OrderEventDTO orderEvent = new OrderEventDTO();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return "Order palaced successfully....";
    }
}
