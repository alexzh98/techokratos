package com.example.technokratostesttask.service;

import com.example.technokratostesttask.Repository.OrderRepository;
import com.example.technokratostesttask.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service("order_service")
@Transactional
@Repository
@Slf4j
public class OrderServiceImpl implements OrderService {
    private OrderRepository repository;

    @Autowired
    public void setRepository(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order save(Order order) {
        log.trace("Trying save order to the DB ");
        return repository.save(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findOrderByConsumerEmail(String email) {
        log.trace("trying find orders by email");
        return repository.findAllByEmail(email);

    }
   public List<Order> findAll(){
        log.trace("trying find  all orders");
        return (List<Order>) repository.findAll();
    }

    @Override
    public List<Order> findByArticle(Integer article) {
        log.trace("trying find orders by article");
        return repository.findByArticle(article);
    }

    @Override
    public List<Order> findByDateBetween(Date date, Date date2) {
        log.trace("trying find between two date");
        return repository.findByDateBetween(date,date2);
    }
}
