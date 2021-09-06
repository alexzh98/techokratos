package com.example.technokratostesttask.service;

import com.example.technokratostesttask.entity.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public interface OrderService {

    Order save(Order order);
    List<Order> findOrderByConsumerEmail(String email);
    List<Order> findByDateBetween(Date date, Date date2);
    List<Order> findAll();
    List<Order> findByArticle(Integer article);
    ResponseEntity<?> createOrder(String email, List<Integer>articles);
    ResponseEntity<?>getOrdersByPositionArticle(int article);
    ResponseEntity<?> getOrdersBetweenTwoDate(String dateStart, String dateEnd);

}
