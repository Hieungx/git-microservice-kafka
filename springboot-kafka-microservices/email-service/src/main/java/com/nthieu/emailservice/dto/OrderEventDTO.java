package com.nthieu.emailservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hieungx
 * 28/09/2022
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventDTO {
    private String message;
    private String status;
    private OrderDTO order;
}
