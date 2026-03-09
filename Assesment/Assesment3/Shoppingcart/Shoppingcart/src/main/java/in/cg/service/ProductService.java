package in.cg.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import in.cg.model.Product;

@Service
public class ProductService {

    private List<Product> products = Arrays.asList(
            new Product(1, "Laptop", 50000),
            new Product(2, "Mobile", 20000),
            new Product(3, "Headphones", 2000)
    );

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }
}