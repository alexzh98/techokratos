package com.example.technokratostesttask.Repository;

import com.example.technokratostesttask.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Long> {

    List<Product> findOneByArticle(@Param("Article") Integer article);
    Optional<Product> findByArticle(@Param("Article") Integer article);

    List<Product> findAllByDeleteIsTrue();
    List<Product> findAllByDeleteIsFalse();
    Product findAllByArticleAndDeleteFalse(@Param("Article")Integer article);
}
