package com.disgroup.solution.repositories;
import com.disgroup.solution.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {
    Iterable<Product> findByNameLike(String name);
    Iterable<Product> findAllByDescription(String match);
    Iterable<Product> findAllByIntroductionPrice(Double price);
}
