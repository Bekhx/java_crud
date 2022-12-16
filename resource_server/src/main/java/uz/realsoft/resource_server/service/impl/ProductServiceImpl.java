package uz.realsoft.resource_server.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.realsoft.resource_server.dto.products.CreateProductDTO;
import uz.realsoft.resource_server.dto.products.UpdateProductDTO;
import uz.realsoft.resource_server.entity.ProductEntity;
import uz.realsoft.resource_server.repository.ProductRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Boolean create(CreateProductDTO dto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        productRepository.save(productEntity);
        return true;
    }

    @Override
    public List<ProductEntity> getAll() {
        return productRepository.getAllByOrderById();
    }

    @Override
    public ProductEntity getById(Long id) {
        return productRepository.getById(id);
    }

    @Override
    public Long update(UpdateProductDTO updateProductDTO, Long id) {
        return productRepository.update(updateProductDTO.getName(), updateProductDTO.getPrice(), id);
    }

    @Override
    public Long delete(Long id) {
        return productRepository.delete(id);
    }
}
