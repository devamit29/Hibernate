package com.service;

public interface Services {
	void addPersonWithAdharCard();

	void addAdharCardWithPerson();

	void getAllDataFromPerson();

	void getAllDataFromAdharCard();

	void getSinglePersonDataWithAdharCard();

	void getSingleAdharcardWithPerson();

	void updateAdharCardWithPersonId();

	void updatePersonWithAdharCardId();

	void deletePersonWithAdharCardId();
	
	void deleteAdharCardWithPersonId();

	void deleteAdharCardOnly();

	void deletePersonOnly();

}
