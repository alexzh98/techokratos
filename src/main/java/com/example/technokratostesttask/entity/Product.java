package com.example.technokratostesttask.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "product")
@Table(name = "product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "price")
    private Double price;
    @Column(name = "delete")
    private Boolean delete;
    @Column(name = "article")
    private Integer article;
    @Column(name = "title")
    private String title;

    @JsonBackReference
    @ManyToMany(mappedBy="products")
    private List<Order> orders = new ArrayList<>();

    public Product(){

    }

    public Product(Double price, Boolean delete, Integer article, String title) {
        this.price = price;
        this.delete = delete;
        this.article = article;
        this.title = title;
    }


}
