package uz.realsoft.resource_server.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.realsoft.resource_server.dto.products.CreateProductDTO;
import uz.realsoft.resource_server.entity.ProductEntity;
import uz.realsoft.resource_server.repository.ProductRepository;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductEntity create(CreateProductDTO dto) {
        return productRepository.create(dto.getName(), dto.getPrice());
    }
}
