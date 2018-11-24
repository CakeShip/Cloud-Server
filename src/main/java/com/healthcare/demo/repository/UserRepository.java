package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.healthcare.demo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findAll();
	List<User> findByFirstNameOrLastName(String firstName,String lastName);
	User findByUsernameAndPassword(String username, String password);
	User findById(int id);

	@Modifying
	// User findPersonById(int id, User update_person);
	@Query("UPDATE User u SET u.username=:#{#update_person.username},u.password=:#{#update_person.password},u.email=:#{#update_person.email},u.firstName=:#{#update_person.firstName},u.lastName=:#{#update_person.lastName} WHERE u.id=(:id)")
	Integer updatePersonDetailsById(@Param("id") int id, @Param("update_person") User update_person);
}
