package uz.realsoft.resource_server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.realsoft.resource_server.dto.products.CreateProductDTO;
import uz.realsoft.resource_server.entity.ProductEntity;
import uz.realsoft.resource_server.service.impl.ProductService;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/")
    public ResponseEntity<ProductEntity> getProduct(@RequestBody CreateProductDTO createProductDTO) {
        ProductEntity productEntity = productService.create(createProductDTO);
        return new ResponseEntity<>(productEntity, HttpStatus.OK);
    }
}
