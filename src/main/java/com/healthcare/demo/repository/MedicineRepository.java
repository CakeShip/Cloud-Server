package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthcare.demo.model.*;

@Repository
public interface MedicineRepository extends JpaRepository<User, Integer> {
//	User deleteMedicineModelById(int id);
	@Query("UPDATE MedicineModel u SET u.isArchived=true WHERE u.id=(:id)")
	User deleteMedicineModelById(@Param("id") int id);

//	User findMedicineModelById(int id);
	@Query("SELECT u FROM MedicineModel u WHERE u.id=(:id)")
	User findMedicineModelById(@Param("id") int id);

//	User updateMedicineModelDetailsById(int id, User update_person);
	@Query("UPDATE MedicineModel u SET u.MedicineName=:#{#update.MedicineName}, u.Price=:#{#update.Price}, u.diseasemodel=:#{#update.diseasemodel} WHERE u.id=(:id)")
	User updateMedicineModelDetailsById(@Param("id") int id, @Param("update") MedicineModel update);
	
//	User findMedicineModelByName(int id, User update_person);
	@Query("SELECT u FROM MedicineModel u WHERE u.MedicineName LIKE (:name)")
	User findMedicineModelByName(@Param("name") String name);
}
