package com.example.technokratostesttask.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity

@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "order_number")
    private Integer order_number;
    @Column(name = "consumer_email")
    private String email;
    @Column(name = "create_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "'date:' yyyy-MM-dd  'time:' HH:mm:ss")
    private Date date;

    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "product_orders",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products=new ArrayList<>();

    public void addProduct(Product product){
        products.add(product);
    }


/*

//    public String toString() {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String result="Order{"+
//                "id = "+ id+
//                " order_number = "+ order_number+
//                " consumer_email = "+ email+
//                " create_date = "+ format.format(date);
//            if(!products.isEmpty()){
//                for(Product r: products){
//                    result+= String.format(
//                            "Product{id = %d ," +
//                            "price = %.2f," +
//                            "delete = %b," +
//                            "article= %s," +
//                            "title= %s" +
//                                    "}",r.getId(),r.getPrice(),r.getDelete(),
//                                        r.getArticle(),r.getTitle());
//                }
//            }
//            return result;
//    }
*/
}

