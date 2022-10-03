package com.nthieu.stockservice.repository;

import com.nthieu.stockservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hieungx
 * 28/09/2022
 **/
public interface OrderRepository extends JpaRepository<Order, Long> {}
