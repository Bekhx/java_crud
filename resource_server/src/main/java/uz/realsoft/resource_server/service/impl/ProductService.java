package uz.realsoft.resource_server.service.impl;

import uz.realsoft.resource_server.dto.products.CreateProductDTO;
import uz.realsoft.resource_server.entity.ProductEntity;

public interface ProductService {
    ProductEntity create(CreateProductDTO dto);
}
