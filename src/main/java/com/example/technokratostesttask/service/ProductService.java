package com.example.technokratostesttask.service;

import com.example.technokratostesttask.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

  Optional  <Product> findByArticle(Integer article);
    List<Product> findAllByDeleteIsTrue();
    List<Product> findActualProducts();
    Product findAllByArticleAndDeleteFalse(Integer article);
}
