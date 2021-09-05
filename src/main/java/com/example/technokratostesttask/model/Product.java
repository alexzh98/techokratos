package com.example.technokratostesttask.model;



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

    @ManyToMany(mappedBy = "products")
    @JsonBackReference
    private List<Order> orders = new ArrayList<>();


    public Long getId() {
        return id;
    }
}
