package com.disgroup.solution.repositories;

import com.disgroup.solution.models.Article;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDate;

public interface ArticleRepository extends PagingAndSortingRepository<Article,Long> {
        Iterable<Article> findByNameLike(String name);
        Iterable<Article> findArticlesByContentContains(String match);
        Iterable<Article> findAllByCreateDate(LocalDate date);
        Iterable<Article> findAllByProductId(Long productId);
}
