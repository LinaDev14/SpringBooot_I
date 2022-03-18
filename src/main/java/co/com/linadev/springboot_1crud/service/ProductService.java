package co.com.linadev.springboot_1crud.service;

import co.com.linadev.springboot_1crud.model.Product;
import co.com.linadev.springboot_1crud.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    // List product
    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    // save product
    public void saveProduct(Product product){
        productRepository.save(product);
    }

    // get product by id
    public Optional<Product> getProductById(Integer id){
        return productRepository.findById(id);
    }

    // get productId by id
    public Product findByProductId(String id){
        return productRepository.findByProductId(id);
    }

    // find by productName
    public List<Product> findAllByProductName(String name){
        return productRepository.findAllByProductName(name);
    }

    // delete product by id
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

}