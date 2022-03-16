package com.melcam.productservice.service;

import com.melcam.productservice.entity.Category;
import com.melcam.productservice.entity.Product;
import com.melcam.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public List<Product> listAllProduct() {
    return productRepository.findAll();
  }

  @Override
  public Product getProduct(Long id) {
    return productRepository.findById(id).orElse(null);
  }

  @Override
  public Product createProduct(Product product) {
    product.setStatus("CREATED");
    product.setCreateAt(new Date());
    return productRepository.save(product);
  }

  @Override
  public Product updateProduct(Product product) {
    Product productDB = getProduct(product.getId());
    if (productDB == null)
      return null;
    productDB.setName(product.getName());
    productDB.setDescription(product.getDescription());
    productDB.setCategory(product.getCategory());
    productDB.setPrice(product.getPrice());

    return productRepository.save(productDB);
  }

  @Override
  public Product deleteProduct(Long id) {
    Product productBD = getProduct(id);
    if (productBD == null)
      return null;
    productBD.setStatus("DELETED");
    return productRepository.save(productBD);
  }

  @Override
  public List<Product> findByCategory(Category category) {
    return productRepository.findByCategory(category);
  }

  @Override
  public Product updateStock(Long id, Double quantity) {
    Product productBD = getProduct(id);
    if (productBD == null)
      return null;
    Double stock = productBD.getStock() + quantity;
    productBD.setStock(stock);
    return productRepository.save(productBD);
  }
}
