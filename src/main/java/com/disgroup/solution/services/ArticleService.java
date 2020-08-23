package com.disgroup.solution.services;

import com.disgroup.solution.interfaces.IArticleService;
import com.disgroup.solution.models.Article;
import com.disgroup.solution.repositories.ArticleRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.Optional;


@Service
public class ArticleService implements IArticleService {
    private ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository=articleRepository;
    }

    public Article createArticle(Article article){
       return articleRepository.save(article);
    }


    public Optional<Article> readArticle(Long id){
         return articleRepository.findById(id);
    }

    public Article updateArticle(Article newArticle){
        return articleRepository.save(newArticle);
    }

    public void deleteArticle(Article article) {
        articleRepository.delete(article);
    }


    public Iterable<Article> getSorted(String fieldName,String order){
        if (!fieldName.isEmpty()){
            return order.equals("asc")? articleRepository.findAll(Sort.by(Sort.Direction.ASC, fieldName)):
                    articleRepository.findAll(Sort.by(Sort.Direction.DESC, fieldName));
        }else{
            return articleRepository.findAll();
        }
    }

    public Iterable<Article> filter(String arg,String field){
        switch (field){
            case ("name"):
                return articleRepository.findByNameLike(arg);
            case("content"):
                 return articleRepository.findArticlesByContentContains(arg);
            case ("date"):
                return articleRepository.findAllByCreateDate(LocalDate.parse(arg));
            case ("product"):
                return articleRepository.findAllByProductId(Long.valueOf(arg));
            default:return null;
        }
    }

}
