package uz.realsoft.resource_server.service.impl;

import uz.realsoft.resource_server.dto.products.CreateProductDTO;
import uz.realsoft.resource_server.dto.products.UpdateProductDTO;
import uz.realsoft.resource_server.entity.ProductEntity;

import java.util.List;

public interface ProductService {
    Boolean create(CreateProductDTO dto);

    List<ProductEntity> getAll();

    ProductEntity getById(Long id);

    Long update(UpdateProductDTO updateProductDTO, Long id);

    Long delete(Long id);
}
