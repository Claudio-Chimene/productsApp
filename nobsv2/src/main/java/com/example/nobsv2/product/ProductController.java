package com.example.nobsv2.product;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.nobsv2.product.model.Product;
import com.example.nobsv2.product.model.ProductDTO;
import com.example.nobsv2.product.model.UpdateProductCommand;
import com.example.nobsv2.product.services.CreateProductService;
import com.example.nobsv2.product.services.DeleteProductService;
import com.example.nobsv2.product.services.GetProductService;
import com.example.nobsv2.product.services.GetProductsService;
import com.example.nobsv2.product.services.UpdateProductService;



@Controller
@RequestMapping("/")
public class ProductController {
	
	
	private final CreateProductService createProductService;
	
	private final GetProductsService getProductsService;
	
	private final UpdateProductService updateProductService;
	
	private final DeleteProductService deleteProductService;
	
	private final GetProductService getProductService;
	
	public ProductController(CreateProductService createProductService, 
									GetProductsService getProductsService,
									UpdateProductService updateProductService, 
									DeleteProductService deleteProductService,
									GetProductService getProductService) {
		this.createProductService = createProductService;
		this.getProductsService = getProductsService;
		this.updateProductService = updateProductService;
		this.deleteProductService = deleteProductService;
		this.getProductService = getProductService;
		
	}
	
	@PostMapping("/product")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
		return createProductService.execute(product);
	}
	
	
	@GetMapping("/products")
	public ResponseEntity<List<ProductDTO>> getProducts() {
		return getProductsService.execute(null);
	}
	
	
	//return one product
	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDTO> getProdductByID(@PathVariable Integer id){
		return getProductService.execute(id);
		
	}
	
	
	@PutMapping("/product/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		return updateProductService.execute(new UpdateProductCommand(id, product));
	}
	
	
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
		return deleteProductService.execute(id);
	}
	
}