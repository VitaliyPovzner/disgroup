package com.disgroup.solution.interfaces;

import com.disgroup.solution.models.Article;
import com.disgroup.solution.models.Product;

import java.util.Optional;

public interface IProductService {
    Product createProduct(Product product);

    Optional<Product> readProduct(Long id);

    Product updateProduct(Product product);

    void deleteProduct(Product product);

    Iterable<Product> getSorted(String fieldName,String order);

    Iterable<Product> filter(String name,String contentMatches);
}
