package com.controller;

import com.services.ServiceImpl;
import com.services.Services;

public class HomeController {
public static void main(String[] args) {
		
		Services s= new ServiceImpl();
		
//		s.addCompanyWithProducts();
		
//		s.showAllCompanyWithProducts();
		
//		s.getSingleCompanyWithMultipleProducts();
		
//		s.updateComapnyUsingCid();
		
//		s.updateProductUsingCid();
		
		s.deleteCompanyUsingCid();
		
//		s.deleteProductUsingCid();
		
//		s.deleteCompanyUsingPid();
		
//		s.addCompanyToExistingProduct();
		
		
	}

}
