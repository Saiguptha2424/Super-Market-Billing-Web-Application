package com.example.demo.controller;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	
	@GetMapping("/products")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		Long l = productService.getOverallAmount();
		System.out.println(l);
		model.addAttribute("msg", productService.getOverallAmount());
		return "products";
	}
	
	@GetMapping("/products/new")
	public String createProductForm(Model model) {
		
		
		Product product = new Product();
		model.addAttribute("product", product);
		return "create_product";
		
	}
	
	@PostMapping("/products")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products/edit/{id}")
	public String editProductForm(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "edit_product";
	}

	@PostMapping("/products/{id}")
	public String updateProduct(@PathVariable Long id,
			@ModelAttribute("product") Product product,
			Model model) {
		
		
		Product existingProduct = productService.getProductById(id);
		existingProduct.setId(id);
		existingProduct.setProductName(product.getProductName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setTotal(product.getPrice()*product.getQuantity());
		
		
		productService.updateProduct(existingProduct);
		return "redirect:/products";		
	}
	
	
	
	@GetMapping("/products/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}

	
	
}
