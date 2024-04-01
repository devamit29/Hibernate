package com.controller;

import com.service.ServiceImpl;
import com.service.Services;

public class HomeController {
	public static void main(String[] args) {
		Services s=new ServiceImpl();
		
		//s.addPersonWithAdharCard();
		
//		s.addPersonWithAdharCard();
		
		//s.getSinglePersonDataWithAdharCard();
		
		//s.getSingleAdharcardWithPerson();
		
		//s.getAllDataFromPerson();
		
		//s.getAllDataFromAdharCard();
		
		//s.updateAdharCardWithPersonId();
		
		//s.updatePersonWithAdharCardId();
		
		//s.deletePersonWithAdharCardId();
		
		//s.deleteAdharCardWithPersonId();
		
		//s.deleteAdharCardOnly();
		
		s.deletePersonOnly();
	}

}
