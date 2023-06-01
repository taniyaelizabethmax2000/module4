package com.example.demo.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.resource.Product;
import com.example.demo.service.ProductService;
@RestController
@RequestMapping("/awsproduct/api.1.0")
public class ProductResource {
	 @Autowired
	 ProductService service;
	 @PostMapping
		@RequestMapping(value="/create",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Product> addProduct(@RequestBody Product product){
		//boolean result=	service.add(product);
			return new ResponseEntity<Product>
			(service.add(product),HttpStatus.ACCEPTED);
			

		}
}
//	 public ResponseEntity<String> hello(@Requestbody Product product){
//		 return new ResponseEntity<>("Hello",HttpStatus.OK);
//	 }
//	 public ResponseEntity<String> hello(@Requestbody Product product){
//		 return ResponseEntity.ok(product).status(HttpStatus.NO_CONTENT);
//	 }
	 
	// public ResponseEntity<String> hello(@Requestbody Product product){
//		 Httpheaders headers=new Httpheaders();
//		 headers.add("food")
		 
	//return ResponseEntity.ok(product).status(HttpStatus.NO_CONTENT).header(null, null);
	// }
 
	 

