package com.healthcare.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.healthcare.demo.model.*;

public interface PersonRepository extends CrudRepository<PersonModel, Integer>{

}
