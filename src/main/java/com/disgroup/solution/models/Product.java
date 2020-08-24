package com.disgroup.solution.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "introduction_price")
    private Double introductionPrice;

    @OneToMany(mappedBy="product", fetch= FetchType.LAZY)
    private Collection<Article> articles;

    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getIntroductionPrice() {
        return introductionPrice;
    }

    public void setIntroductionPrice(Double introductionPrice) {
        this.introductionPrice = introductionPrice;
    }
}
