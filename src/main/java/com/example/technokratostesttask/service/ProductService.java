package com.example.technokratostesttask.service;

import com.example.technokratostesttask.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

  Optional  <Product> findOneByArticle(Integer article);
    List<Product> findAllByDeleteIsTrue();
    List<Product> findActualProducts();
    Product findAllByArticleAndDeleteFalse(Integer article);
}
