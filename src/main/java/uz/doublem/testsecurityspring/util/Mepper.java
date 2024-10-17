package uz.doublem.testsecurityspring.util;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import uz.doublem.testsecurityspring.entity.*;
import uz.doublem.testsecurityspring.payload.ProductDTO;
import uz.doublem.testsecurityspring.payload.UserDTO;

@Service
public class Mepper {

    public Product mepDtoToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setProductStatus(ProductStatus.ACTIVE);
        return product;
    }

    public Product mepDtoToProduct(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        return product;
    }

    public User mepNewDtoToUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setRole(new UserRole(Role.USER));
        return user;
    }
}
