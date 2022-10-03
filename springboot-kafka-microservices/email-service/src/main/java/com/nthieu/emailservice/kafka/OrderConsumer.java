package com.nthieu.emailservice.kafka;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nthieu.emailservice.dto.OrderEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @author hieungx
 * 28/09/2022
 **/
@Service
public class OrderConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void Consume(String orderEvent) {
        LOGGER.info(String.format("Order event received in stock service => [%s]", orderEvent));
        OrderEventDTO dtoResult = convertJsonToOrderEventDTO(orderEvent);
        LOGGER.info(String.format("Order event received in stock service => [%s]", dtoResult.toString()));
        // TODO: send email to the customer
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
