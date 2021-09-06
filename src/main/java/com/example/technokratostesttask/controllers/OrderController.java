package com.example.technokratostesttask.controllers;


import com.example.technokratostesttask.model.Order;
import com.example.technokratostesttask.model.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.technokratostesttask.service.OrderService;
import com.example.technokratostesttask.service.ProductService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
//@RequestMapping("/orders")
public class OrderController {
private OrderService orderService;
private ProductService productService;
Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    @Qualifier("order_service")
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
        @Autowired
        @Qualifier("product_service")
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new")
    public @ResponseBody
    ResponseEntity<?> createOrder(@RequestParam(name = "email",required = false)String email,
                               @RequestParam(name = "article",required = false)Integer... articles){
        Order order = new Order();
        if(email==null){
            return new ResponseEntity<String>("Не был указан емейл",HttpStatus.BAD_REQUEST);
        }
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        log.trace("generate orderNumber");
        int dateHash = date.hashCode();
        int hash = dateHash>0? dateHash: dateHash*-1;
        order.setOrder_number(hash);
        log.trace("order.number: "+order.getOrder_number());
        order.setDate(date);
        order.setEmail(email);
        List<Product> products = new ArrayList<>();
        log.trace("add position in order");
        if(articles!=null) {
            for (int i : articles) {
                Optional<Product> product = productService.findByArticle(i);
                product.ifPresent(products::add);
            }
        }
        else {
            return new ResponseEntity<String>("Не было выбрано ни одного артикула!",HttpStatus.BAD_REQUEST);
        }
        if(products.isEmpty() || products.get(0)==null){
            return new ResponseEntity<String>("Не было выбрано ни одной актуальной позиции!",HttpStatus.NOT_FOUND);
        }
        log.trace("position added:"+products.size());
        order.setProducts(products);

       orderService.save(order);

        return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
    }
    @GetMapping( value = "/orders",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<Order>> index(){
        log.trace("trying order service.findAll");
       // return null;
            return new ResponseEntity<List<Order>>(orderService.findAll(),HttpStatus.OK);

    }
    @GetMapping("/byEmail")
    public @ResponseBody
    ResponseEntity<?>getOrdersByEmail(@RequestParam(value = "email",required = false,defaultValue = "")String email){
        log.trace("trying findOrderByConsumerEmail");
        List<Order> orders = new ArrayList<>(orderService.findOrderByConsumerEmail(email));
        log.trace("found orders: " +orders.size());
        if(orders.isEmpty()){
            return new ResponseEntity<String>("Заказов для этой почты нет!",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
    }
@GetMapping("/betweenTwoDate")
public @ResponseBody
    ResponseEntity<?> getOrdersBetweenTwoDate(@RequestParam(name = "start",required = false,defaultValue = "1970-01-01") String dateStart,
                                              @RequestParam(name = "end",required = false,defaultValue = "2099-12-31")String dateEnd){
        log.trace("getMaping /betweenTwoDate");
      try {
          Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
          log.trace("start date: "+startDate);
          Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
          log.trace("endDate: "+endDate);
          List<Order> orders = new ArrayList<>(orderService.findByDateBetween(startDate,endDate));
          log.trace("found orders: "+orders.size());
          if(orders.isEmpty()){return new ResponseEntity<String>("Заказов в этом промежутке нет!",HttpStatus.NOT_FOUND);}
          return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
      }
      catch (ParseException e){
          log.error("parse date exception");
          return new ResponseEntity<String >("unsupported date format",HttpStatus.NO_CONTENT);

      }
    }
@GetMapping("/findOrderByArticle")
    public @ResponseBody
    ResponseEntity<?> getOrdersByPositionArticle(@RequestParam(name = "article")
                                                 Integer article){
        log.trace("trying find orders by article");
        List<Order> list = new ArrayList<>(orderService.findByArticle(article));
        return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
    }
    @GetMapping("/findByArticle")
public @ResponseBody
    ResponseEntity<?> getProductsByArticle(@RequestParam(name = "article")
                                           Integer article){
        log.trace("trying find product by article");
        Optional<Product> product = productService.findByArticle(article);
        if(product.isEmpty()){
            return new ResponseEntity<String>("По введённому артикулу ничего не найдено",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product.get(),HttpStatus.OK);
}

@GetMapping("/findDeletePosition")
public @ResponseBody
    ResponseEntity<?> getAllDeleteProduct(){
        log.trace("trying find actual products");
        return new ResponseEntity<List<Product>>(productService.findAllByDeleteIsTrue(),HttpStatus.OK);


}

}
