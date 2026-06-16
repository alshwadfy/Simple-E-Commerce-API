package com.SimpleE_Commerce.Demo.Service;

import com.SimpleE_Commerce.Demo.DTO.ProductDTO;
import com.SimpleE_Commerce.Demo.Entity.Product;
import com.SimpleE_Commerce.Demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService {


    @Autowired
    private ProductRepository  productRepository;


    public List<ProductDTO> findAll() {
        return productRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
    }
    public ProductDTO findById(int id) {
        return productRepository
                .findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));
    }
    public ProductDTO Create(Product product) {
        productRepository.save(product);
        return convertToDTO(product);

        }
    public void delete(int id) {
        productRepository.deleteById(id);
            }
    public ProductDTO update(int id, ProductDTO productDTO) {
        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
                product.setName(productDTO.getName());
                product.setDescription(productDTO.getDescription());
                product.setPrice(productDTO.getPrice());
                product.setQuantity(productDTO.getQuantity());
                productRepository.save(product);
                return convertToDTO(product);




    }




    private ProductDTO convertToDTO(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        dto.setQuantity(product.getQuantity());
        dto.setCategoryId(
                product.getCategory() != null ? product.getCategory().getId() : 0
        );
        return dto;
    }

}

