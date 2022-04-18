package jpa.buddy.stockmanagement.repositories;

import jpa.buddy.stockmanagement.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("select count(p) from Product p where upper(p.productType.name) = upper(?1)")
    long countByProductType(String name);
}