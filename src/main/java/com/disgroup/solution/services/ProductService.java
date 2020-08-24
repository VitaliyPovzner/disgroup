package com.disgroup.solution.services;

import com.disgroup.solution.interfaces.IProductService;
import com.disgroup.solution.models.Article;
import com.disgroup.solution.models.Product;
import com.disgroup.solution.repositories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
@Service
public class ProductService implements IProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }


    public Product createProduct(Product product) {
        return this.productRepository.save(product);
    }


    public Optional<Product> readProduct(Long id) {
        return this.productRepository.findById(id);
    }


    public Product updateProduct(Product product) {
       return this.productRepository.save(product);
    }


    public void deleteProduct(Product product) {
        this.productRepository.delete(product);
    }


    public Iterable<Product> getSorted(String fieldName, String order) {
        System.out.println("tyt");
        if (fieldName!=null){
            return order.equals("asc")? productRepository.
                    findAll(Sort.by(Sort.Direction.ASC, fieldName)):
                    productRepository.findAll(Sort.by(Sort.Direction.DESC, fieldName));
        }else{
            return productRepository.findAll();
        }
    }

    @Override
    public Iterable<Product> filter(String arg,String field) {
        switch (field){
            case ("name"):
                return productRepository.findByNameLike(arg);
            case("description"):
                return productRepository.findAllByDescription(arg);
            case ("price"):
                return productRepository.findAllByIntroductionPrice(Double.valueOf(arg));
            default:return null;
        }
    }
}
