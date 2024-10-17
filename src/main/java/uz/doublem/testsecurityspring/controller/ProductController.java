package uz.doublem.testsecurityspring.controller;


import jakarta.persistence.Access;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PostAuthorize;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.doublem.testsecurityspring.payload.ProductDTO;
import uz.doublem.testsecurityspring.payload.ResponseTemplate;
import uz.doublem.testsecurityspring.service.ProductService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public ResponseEntity<?> getAllProducts() {
       ResponseTemplate resp = productService.getAllProducts();
       return ResponseEntity.status(resp.getSuccess()?200:400).body(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        ResponseTemplate resp = productService.getProductById(id);
        return ResponseEntity.status(resp.getSuccess()?200:400).body(resp);
    }


    @PostMapping

    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        ResponseTemplate resp = productService.saveProduct(productDTO);
        return ResponseEntity.status(resp.getSuccess()?200:400).body(resp);
    }

    @PutMapping("/{id}")

    public ResponseEntity<?> editProduct(@PathVariable Integer id, @RequestBody ProductDTO product){
        return ResponseEntity.ok(productService.editProduct(id,product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
        return ResponseEntity.ok(productService.delete(id));
    }



}
