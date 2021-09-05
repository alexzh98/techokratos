package com.example.technokratostesttask.service;

import com.example.technokratostesttask.model.Order;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface OrderService {

    Order save(Order order);
    List<Order> findOrderByConsumerEmail(String email);
    List<Order> findByDateBetween(Date date, Date date2);
    List<Order> findAll();
    List<Order> findByArticle(Integer article);

}
