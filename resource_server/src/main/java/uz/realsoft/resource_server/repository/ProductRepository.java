package uz.realsoft.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.realsoft.resource_server.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    @Query(value = "insert into products (name, price) values (:name, :price) returning *;", nativeQuery = true)
    ProductEntity create(@Param("name") String name,@Param("price") Double price);
}
