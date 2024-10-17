package uz.doublem.testsecurityspring.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.doublem.testsecurityspring.entity.ProductStatus;
import uz.doublem.testsecurityspring.payload.ProductDTO;
import uz.doublem.testsecurityspring.payload.ResponseTemplate;
import uz.doublem.testsecurityspring.repository.ProductRepository;
import uz.doublem.testsecurityspring.entity.Product;
import uz.doublem.testsecurityspring.util.Mepper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final Mepper mepper;

    public ResponseTemplate getAllProducts() {
        List<Product> products = productRepository.findAll();
        if (!products.isEmpty()) {
            return ResponseTemplate.builder().message("There is all Products").success(true).data(products).build();
        }
        return ResponseTemplate.builder().message("Products is empty").success(false).data(products).build();
    }

    public ResponseTemplate getProductById(Integer id) {
        Optional<Product> opProduct = productRepository.findById(id);
        if (opProduct.isPresent()) {
            return ResponseTemplate.builder().message("Product exists by Id").success(true).data(opProduct.get()).build();
        }
        return ResponseTemplate.builder().message("Not Found by This Id").success(false).data(null).build();
    }

    //this is return Resp by Fields
    public ResponseTemplate getResp(String message, boolean success, Object data) {
        return ResponseTemplate.builder().message(message).success(success).data(data).build();
    }

    public ResponseTemplate saveProduct(ProductDTO productDTO) {
        Product product = mepper.mepDtoToProduct(productDTO);
        product.setProductStatus(ProductStatus.ACTIVE);
        Product save = productRepository.save(product);
        return getResp("saved product",true,save);
    }

    public ResponseTemplate editProduct(Integer id, ProductDTO productDTO) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            Product product1 = mepper.mepDtoToProduct(product.get(), productDTO);
            return getResp("Successfully edited product",true,product1);
        }
        return getResp("Product not found",false,null);
    }

    @Transactional
    public ResponseTemplate delete(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return getResp("Successfully deleted",true,null);
        }
        return getResp("Not Found this product",false,null);
    }
}
