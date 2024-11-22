package com.example.nobsv2.product.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.nobsv2.product.Comand;
import com.example.nobsv2.product.ProductRepository;
import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;

@Service
public class CreateProductService implements Comand<Product, ProductDTO>{
	private final ProductRepository productRepository;
	
	
	
	public CreateProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}



	@Override
	public ResponseEntity<ProductDTO> execute(Product product) {
		
		Product savedProduct = productRepository.save(product);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(savedProduct));
	}
}