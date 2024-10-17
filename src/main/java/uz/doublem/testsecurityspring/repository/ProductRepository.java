package uz.doublem.testsecurityspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.doublem.testsecurityspring.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {


}
