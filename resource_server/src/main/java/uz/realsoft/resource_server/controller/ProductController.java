package uz.realsoft.resource_server.controller;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import uz.realsoft.resource_server.dto.products.*;
import uz.realsoft.resource_server.entity.ProductEntity;
import uz.realsoft.resource_server.service.impl.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5173")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateProductResponseDTO createProduct(@RequestBody CreateProductDTO createProductDTO) {
        productService.create(createProductDTO);
        return new CreateProductResponseDTO(true);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductEntity getProductById(@PathVariable @NotNull Long id) {
        return productService.getById(id);
    }

    @GetMapping("/")
    public List<ProductEntity> getProducts() {
        return productService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UpdateProductResponseDTO updateProduct(@RequestBody UpdateProductDTO updateProductDTO, @PathVariable("id") @NotNull Long id) {
        productService.update(updateProductDTO, id);
        return new UpdateProductResponseDTO(true);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public DeleteProductResponseDTO deleteProduct(@PathVariable("id") @NotNull Long id) {
        productService.delete(id);
        return new DeleteProductResponseDTO(true);
    }
}
