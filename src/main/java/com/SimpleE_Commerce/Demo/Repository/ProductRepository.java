package com.SimpleE_Commerce.Demo.Repository;

import com.SimpleE_Commerce.Demo.DTO.ProductDTO;
import com.SimpleE_Commerce.Demo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

}
