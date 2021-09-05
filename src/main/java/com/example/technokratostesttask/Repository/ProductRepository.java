package com.example.technokratostesttask.Repository;

import com.example.technokratostesttask.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findAllByArticle(@Param("Article") Integer article);
    Optional<Product> findByArticle(@Param("Article") Integer article);

    List<Product> findAllByDeleteIsTrue();
    List<Product> findAllByDeleteIsFalse();
    Product findAllByArticleAndDeleteFalse(@Param("Article")Integer article);
}
