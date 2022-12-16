package uz.realsoft.resource_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uz.realsoft.resource_server.entity.ProductEntity;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
//    @Query(value = "insert into products (name, price) values (:name, :price) returning *", nativeQuery = true)
//    ProductEntity create(@Param("name") String name,@Param("price") Double price);

    List<ProductEntity> getAllByOrderById();

    @Query(value = "select * from products where id = :id", nativeQuery = true)
    ProductEntity getById(@Param("id") Long id);

    @Query(value = "update products set name = :name, price = :price where id = :id returning id", nativeQuery = true)
    Long update(@Param("name") String name, @Param("price") Double price, @Param("id") Long id);

    @Query(value = "delete from products where id = :id returning id", nativeQuery = true)
    Long delete(@Param("id") Long id);
}
