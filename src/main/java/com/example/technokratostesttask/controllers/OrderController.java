package com.example.technokratostesttask.controllers;
import com.example.technokratostesttask.entity.Order;
import com.example.technokratostesttask.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.technokratostesttask.service.OrderService;
import com.example.technokratostesttask.service.ProductService;

import java.util.*;

    @RestController
 public class OrderController {
    private OrderService orderService;
    private ProductService productService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }



    @PostMapping("/new")
    public @ResponseBody
    ResponseEntity<?> createOrder(@RequestParam(name = "email",required = false)String email,
                                  @RequestParam(name = "article",required = false)List<Integer> articles){

        if(email==null){
            return new ResponseEntity<String>("Не был указан емейл",HttpStatus.BAD_REQUEST);
        }
        if(articles.size()==0){
            return new ResponseEntity<String>("не было выбрано ни одного артикула",HttpStatus.BAD_REQUEST);
        }
        System.out.println("a");
        return orderService.createOrder(email,articles);
    }


    @GetMapping( value = "/orders",produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<List<Order>> index(){
        return new ResponseEntity<List<Order>>(orderService.findAll(),HttpStatus.OK);

    }
    @GetMapping("/byEmail")
    public @ResponseBody
    ResponseEntity<?>getOrdersByEmail(@RequestParam(value = "email",required = false,defaultValue = "")String email){

        List<Order> orders = new ArrayList<>(orderService.findOrderByConsumerEmail(email));
        if(orders.isEmpty()){
            return new ResponseEntity<String>("Заказов для этой почты нет!",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
    }


    @GetMapping("/betweenTwoDate")
    public @ResponseBody
    ResponseEntity<?> getOrdersBetweenTwoDate(@RequestParam(name = "start",required = false,defaultValue = "1970-01-01") String dateStart,
                                              @RequestParam(name = "end",required = false,defaultValue = "2099-12-31") String dateEnd){

        return orderService.getOrdersBetweenTwoDate(dateStart,dateEnd);

    }

    @GetMapping("/findOrderByArticle")
    public @ResponseBody
    ResponseEntity<?> getOrdersByPositionArticle(@RequestParam(name = "article") Integer article){

        List<Order> list = new ArrayList<>(orderService.findByArticle(article));
        return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
    }

    @GetMapping("/findByArticle")
    public @ResponseBody
    ResponseEntity<?> getProductsByArticle(@RequestParam(name = "article")
                                           Integer article){

        Optional<Product> product = productService.findOneByArticle(article);
        if(product.isEmpty()){
            return new ResponseEntity<String>("По введённому артикулу ничего не найдено",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Product>(product.get(),HttpStatus.OK);
}

    @GetMapping("/findDeletePosition")
    public @ResponseBody
    ResponseEntity<?> getAllDeleteProduct(){

        return new ResponseEntity<List<Product>>(productService.findAllByDeleteIsTrue(),HttpStatus.OK);


}

}
