package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.awsrepository.ProductRepository;
import com.example.demo.resource.Product;

@Service
public class ProductService {

	
	@Autowired
	ProductRepository productRepository;
	public Product add(Product product) {
		return productRepository.save(product);
		
	}
	}

