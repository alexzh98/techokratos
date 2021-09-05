package com.example.technokratostesttask.Repository;

import com.example.technokratostesttask.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {
    List<Order> findAllByEmail(String email);
    List<Order> findByDateBetween(Date date, Date date2);
    @Query(value = "select * from orders where id IN " +
            "(select order_id from product_orders where product_id= ((select t. id from product  t where article=:article)))",nativeQuery = true)
    List<Order> findByArticle(@Param("article") Integer article);
}
