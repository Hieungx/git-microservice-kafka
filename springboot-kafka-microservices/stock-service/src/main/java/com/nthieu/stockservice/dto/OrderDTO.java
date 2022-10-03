package com.nthieu.stockservice.dto;

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
public class OrderDTO {
    private String name;
    private Integer qty;
    private Double price;
}
