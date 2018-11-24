package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.model.*;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecordModel, Integer> {
	List<MedicalRecordModel> findAll();
    MedicalRecordModel findById(int id);

	@Query("UPDATE MedicalRecordModel u SET u.Name=:#{#update.Name},u.Birthday=:#{#update.Birthday},u.Sex=:#{#update.Sex},u.Admission_Date=:#{#update.Admission_Date},u.Discharge_Date=:#{#update.Discharge_Date},u.Name=:#{#update.Name},u.Name=:#{#update.Name},u.TotalBill=:#{#update.TotalBill} WHERE u.id=(:id)")
    MedicalRecordModel updateById(@Param("id") int id, @Param("update") MedicalRecordModel update);
}
