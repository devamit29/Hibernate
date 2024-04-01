package com.controller;

import com.service.ServiceImpl;
import com.service.Services;

public class HomeController {
	
	public static void main(String[] args) {
		Services s = new ServiceImpl();
		
		//s.addDriverWithMultipleVehicle();
		//s.showAllDriverWithVehicle();
		//s.showSingleDriverWithVehicle();
		//s.updateDriver();
		//s.deleteDriver();
		s.updateVehicleUsingDriverID();
		//s.deleteParticularVehicleUsingDriver();
		//s.addDriverWithMultipleVehicle();
	}
	

}
