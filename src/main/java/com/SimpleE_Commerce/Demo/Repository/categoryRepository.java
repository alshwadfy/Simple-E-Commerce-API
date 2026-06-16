package com.SimpleE_Commerce.Demo.Repository;

import com.SimpleE_Commerce.Demo.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface categoryRepository extends JpaRepository<Category,Integer> {

}
