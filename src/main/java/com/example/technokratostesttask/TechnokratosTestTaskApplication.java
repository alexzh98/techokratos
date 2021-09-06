package com.example.technokratostesttask;

import com.example.technokratostesttask.Repository.OrderRepository;
import com.example.technokratostesttask.Repository.ProductRepository;
import com.example.technokratostesttask.entity.Order;
import com.example.technokratostesttask.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class TechnokratosTestTaskApplication implements CommandLineRunner {
@Autowired
    private OrderRepository orderRepository;
@Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(TechnokratosTestTaskApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Product irbis = new Product(17099d,false,170004141,"Irbis NB248 14.1, black");
        Product lenovo = new Product(19999d,false,190011140,"Lenovo IdeaPad Slim 14.0, blue");
        Product asus = new Product(21999d,false,210002116,"Asus Laptop11 11.6, black");
        Product lenovo145 = new Product(21999d,false,210004156,"Lenovo IdeaPad S145 15.6, gray");
        Product lenovo1 = new Product(22899d,false,220005116,"Lenovo IdeaPad 1 11.6, blue");
        Product lenovo2 = new Product(22999d,false,220006115,"LenovoIdeaPad 1 11.6, gray");
        Product lenovo3 = new Product(22999d,false,220007140,"Acer Aspire 1 11.6, blue");

        productRepository.save(irbis);
        productRepository.save(lenovo);
        productRepository.save(asus);
        productRepository.save(lenovo1);
        productRepository.save(lenovo1);
        productRepository.save(lenovo2);
        productRepository.save(lenovo3);

        Date f = new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-02");
        Date f2 = new SimpleDateFormat("yyyy-MM-dd").parse("2021-04-02");

        Order order1 = new Order();
        order1.setDate(f);
        int dateHash = f.hashCode();
        int hash = dateHash>0? dateHash: dateHash*-1;
        order1.setOrder_number(hash);
        order1.setEmail("asdad@mail.ru");
        order1.addProduct(irbis);
        order1.addProduct(asus);

        Order order2 = new Order();
        int dateHash2 = f2.hashCode();
        int hash2 = dateHash2>0? dateHash2: dateHash2*-1;
        order2.setOrder_number(hash2);
        order2.setDate(f2);
        order2.setEmail("obcvb@mail.ru");
        order2.addProduct(lenovo);
        order2.addProduct(irbis);

        orderRepository.save(order1);
        orderRepository.save(order2);
    }
}
