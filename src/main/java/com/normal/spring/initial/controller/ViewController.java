package com.normal.spring.initial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
	
	@RequestMapping("/locale")
	   public String locale() {
	      return "locale";
	   }
	
   @RequestMapping("/view-products")
   public String viewProducts() {
      return "view-products";
   }
   @RequestMapping("/add-products")
   public String addProducts() {
      return "add-products";
   }   
}