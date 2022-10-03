package com.nthieu.stockservice.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author hieungx
 * 28/09/2022
 **/
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(schema = "springdocker",name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "qty")
    private Integer qty;
    @Column(name = "price")
    private Double price;
}
