package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthcare.demo.model.*;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecordModel, Integer> {
//	User deleteMedicalRecordById(int id);
	@Query("UPDATE MedicalRecordModel u SET u.isArchived=true WHERE u.id=(:id)")
	User deleteMedicalRecordById(@Param("id") int id);

//	User findMedicalRecordById(int id);
	@Query("SELECT u FROM MedicalRecordModel u WHERE u.id=(:id)")
	User findMedicalRecordById(@Param("id") int id);

//	User updateMedicalRecordModelById(int id, User update_person);
	@Query("UPDATE MedicalRecordModel u SET u.Name=:#{#update.Name},u.Birthday=:#{#update.Birthday},u.Sex=:#{#update.Sex},u.Admission_Date=:#{#update.Admission_Date},u.Discharge_Date=:#{#update.Discharge_Date},u.Name=:#{#update.Name},u.Name=:#{#update.Name},u.TotalBill=:#{#update.TotalBill} WHERE u.id=(:id)")
	User updateMedicalRecordModelById(@Param("id") int id, @Param("update") MedicalRecordModel update);
	
//	User findMedicalRecordModelByName(int id, User update_person);
	@Query("SELECT u FROM MedicalRecordModel u WHERE u.Name LIKE (:name)")
	User findMedicalRecordModelByName(@Param("name") String name);
}
