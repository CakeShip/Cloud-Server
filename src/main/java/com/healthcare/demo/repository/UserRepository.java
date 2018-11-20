package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthcare.demo.model.*;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//	User findUserByUsernamePassword(String username, String password);
	@Query("SELECT u FROM User u  WHERE u.username=(:username) AND u.password= (:password)")
	User findUserByUsernamePassword(@Param("username") String username, @Param("password") String password);

//	User deleteUserById(int id);
	@Query("UPDATE user u SET u.isArchived=true WHERE u.id=(:id)")
	User deleteUserById(@Param("id") int id);

//	User findPersonById(int id);
	@Query("UPDATE user u SET u.isArchived=true WHERE u.id=(:id)")
	User findPersonById(@Param("id") int id);

//	User findPersonById(int id, User update_person);
	@Query("UPDATE user u SET u.username=:#{#update_person.username},u.password=:#{#update_person.password},u.email=:#{#update_person.email}," +
	"u.firstname=:#{#update_person.firstName},u.lastname=:#{#update_person.lastName},u.isArchived=false WHERE u.id=(:id)")
	User updatePersonDetailsById(@Param("id") int id, @Param("update_person") User update_person);


}
