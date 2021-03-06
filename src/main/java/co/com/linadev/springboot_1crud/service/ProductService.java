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
    public Product saveProduct(Product product){
        return productRepository.save(product);
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
        return productRepository.findAllByProductNameContainingIgnoreCase(name);
    }

    // filter prices higher than
    public List<Product> findAllByProductPriceGreaterThan(Float price){
        return productRepository.findAllByProductPriceGreaterThan(price);
    }

    // filter prices below
    public List<Product> findAllByProductPriceLessThan(Float price){
        return productRepository.findAllByProductPriceLessThan(price);
    }

    // filter prices equal to
    public List<Product> findAllByProductPrice(Float price){
        return productRepository.findAllByProductPrice(price);
    }

    // update product
    public Product updateProduct(Product product){
        Optional<Product> productData = productRepository.findById(product.getId());

        if(productData.isEmpty()){
            throw new IllegalArgumentException("Sorry, the requested product is not in stock.");
        }

        return productRepository.save(product);
    }

    // delete product by id
    public void deleteProduct(Integer id){
        productRepository.deleteById(id);
    }

}
