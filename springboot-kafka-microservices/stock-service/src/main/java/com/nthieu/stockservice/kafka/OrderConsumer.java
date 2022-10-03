package com.nthieu.stockservice.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nthieu.stockservice.dto.OrderEventDTO;
import com.nthieu.stockservice.entity.Order;
import com.nthieu.stockservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author hieungx
 * 28/09/2022
 **/
@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @Resource
    private OrderRepository orderRepository;

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void Consume(String orderEvent) {
        LOGGER.info(String.format("Order event received in stock service => [%s]", orderEvent.toString()));

        OrderEventDTO eventResult = convertJsonToOrderEventDTO(orderEvent);

        // TODO: save the order event into the database
        Order order = new Order();
        order.setName(eventResult.getOrder().getName());
        order.setQty(eventResult.getOrder().getQty());
        order.setPrice(eventResult.getOrder().getPrice());

        orderRepository.save(order);
    }

    private OrderEventDTO convertJsonToOrderEventDTO(String orderEvent) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(orderEvent, OrderEventDTO.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
