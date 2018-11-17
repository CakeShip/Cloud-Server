package com.healthcare.demo.service;

import java.util.List;

import com.healthcare.demo.model.*;

public interface PersonService {
	
	public PersonModel getPersonInfo(PersonModel personModel);	
	public List<PersonModel> getAll();
	public void registerPerson(PersonModel personModel);
}
