package uz.realsoft.resource_server.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="products")
@Data
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Double price;
}
