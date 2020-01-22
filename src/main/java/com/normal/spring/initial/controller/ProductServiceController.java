package com.normal.spring.initial.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.normal.spring.initial.model.Product;
import com.normal.spring.initial.service.ProductService;


@RestController
public class ProductServiceController {
	
   private static final Logger LOG = Logger.getLogger(ProductServiceController.class.getName());
	
   @Autowired(required=true)
   ProductService productService;

   @RequestMapping(value = "/products")
   public ResponseEntity<Object> getProduct() {
	  LOG.log(Level.INFO, "getProducts()....");
      return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
   }
   @PutMapping(value = "/products/{id}")
   public ResponseEntity<Object> 
      updateProduct(@PathVariable("id") String id, @RequestBody Product product) {
	   LOG.log(Level.INFO, "updateProduct()...."+id);
      productService.updateProduct(id, product);
      return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
   }
   @DeleteMapping(value = "/products/{id}")
   public ResponseEntity<Object> delete(@PathVariable("id") String id) {
	  LOG.log(Level.INFO, "deleteProduct()...."+id);
      productService.deleteProduct(id);
      return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
   }
   @PostMapping(value = "/products")
   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
	  LOG.log(Level.INFO, "createProduct()...."+product.getName());
      productService.createProduct(product);
      return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
   }
}
