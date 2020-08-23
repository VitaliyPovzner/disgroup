package com.disgroup.solution.controllers;
import com.disgroup.solution.interfaces.IArticleService;
import com.disgroup.solution.models.Article;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;


@RestController
@RequestMapping("/article")
public class ArticleController {
    private IArticleService articleService;

    public ArticleController(IArticleService articleService){
        this.articleService=articleService;
    }

    @PostMapping()
    public Article createArticle(@RequestBody Article article){
        return articleService.createArticle(article);
    }

    @GetMapping("/{id}")
    public Article getOne(@PathVariable Long id){
        return articleService.readArticle(id)
                .orElseThrow(() ->new ResponseStatusException
                        (HttpStatus.NOT_FOUND,"no entity found"));
    }


    @PutMapping
    public Article replaceArticle(@RequestBody Article article){
        return articleService.updateArticle(article);
    }

    @DeleteMapping()
    public void deleteArticle(@RequestBody Article article){
        articleService.deleteArticle(article);
    }

    @GetMapping("/all")
    public Iterable<Article> getSorted(@RequestParam String fieldName,@RequestParam String order){
        return articleService.getSorted(fieldName,order);
    }

    @GetMapping(params = "name")
    public Iterable<Article> getByName(@RequestParam String name){
        return articleService.filter(name,"name");
    }
    @GetMapping(params = "content")
    public Iterable<Article> getByContent(@RequestParam String content){
        return articleService.filter(content,"content");
    }
    @GetMapping(params = "date")
    public Iterable<Article> getByCreateDate(@DateTimeFormat(iso= DateTimeFormat.ISO.DATE) @RequestParam LocalDate date){
        return articleService.filter(date.toString(),"date");
    }
    @GetMapping(params = "productId")
    public Iterable<Article> getByProductId(@RequestParam Long productId){
        return articleService.filter(productId.toString(),"product");
    }
}
