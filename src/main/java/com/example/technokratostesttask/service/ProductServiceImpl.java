package com.example.technokratostesttask.service;


import com.example.technokratostesttask.Repository.ProductRepository;
import com.example.technokratostesttask.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("product_service")
@Repository
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;
    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional< Product> findOneByArticle(Integer article) {
        return repository.findByArticle(article);
    }

    @Override
    public List<Product> findAllByDeleteIsTrue() {
        return repository.findAllByDeleteIsTrue();

    }

    @Override
    public List<Product> findActualProducts() {
        return repository.findAllByDeleteIsFalse();
    }

    @Override
    public Product findAllByArticleAndDeleteFalse(Integer article) {
        return repository.findAllByArticleAndDeleteFalse(article);
    }
}
