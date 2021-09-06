package com.example.technokratostesttask.service;
import com.example.technokratostesttask.Repository.OrderRepository;
import com.example.technokratostesttask.entity.Order;
import com.example.technokratostesttask.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("order_service")
@Transactional
@Repository
public class OrderServiceImpl implements OrderService {
    private OrderRepository repository;
    @Autowired
    private ProductService productService;
    @Autowired
    public void setRepository(OrderRepository repository) {
        this.repository = repository;
    }

    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public ResponseEntity<?> createOrder(String email, List<Integer> articles)   {
        List<Product> products =new ArrayList<>();
        articles.forEach(o->productService.findOneByArticle(o).ifPresent(products::add));

        if(products.isEmpty()|| products.get(0)==null){
            return new ResponseEntity<String>("не было выбрано ни одного актуального артикула!", HttpStatus.BAD_REQUEST);
        }


        Date date = new Date();
        Order order = new Order();

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int dateHash = date.hashCode();
        int hash = dateHash>0?dateHash:dateHash*-1;

        order.setDate(date);
        order.setEmail(email);
        order.setOrder_number(hash);
        order.setProducts(products);

        repository.save(order);

        return new ResponseEntity<String>("Заказ был создан",HttpStatus.OK);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> findOrderByConsumerEmail(String email) {
        return repository.findAllByEmail(email);

    }
   public List<Order> findAll(){
        return (List<Order>) repository.findAll();
    }

    @Override
    public List<Order> findByArticle(Integer article) {
        return repository.findByArticle(article);
    }

    @Override
    public List<Order> findByDateBetween(Date date, Date date2) {
        return repository.findByDateBetween(date,date2);
    }

    @Override
    public ResponseEntity<?> getOrdersByPositionArticle(int article) {
        return null;
    }

    @Override
    public ResponseEntity<?> getOrdersBetweenTwoDate(String dateStart, String dateEnd){
        try {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
            List<Order> orders = new ArrayList<>(findByDateBetween(startDate, end));
            if (!orders.isEmpty()) {
                return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);}
        }
        catch (ParseException e){
            return new ResponseEntity<String>("Неверный формат даты. попробуйте ещё раз с форматом yyyy-MM-dd",HttpStatus.BAD_REQUEST);}
        return new ResponseEntity<String>("Не найдено",HttpStatus.NOT_FOUND);
    }

}
