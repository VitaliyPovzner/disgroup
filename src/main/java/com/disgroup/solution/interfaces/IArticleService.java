package com.disgroup.solution.interfaces;

import com.disgroup.solution.models.Article;

import java.util.Optional;

public interface IArticleService {

    Article createArticle(Article article);

    Optional<Article> readArticle(Long id);

    Article updateArticle(Article article);

    void deleteArticle(Article article);

    Iterable<Article> getSorted(String fieldName,String order);

    Iterable<Article> filter(String name,String contentMatches);
}
