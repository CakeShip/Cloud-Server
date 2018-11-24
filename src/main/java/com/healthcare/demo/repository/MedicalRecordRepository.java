package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.model.*;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecordModel, Integer> {
	List<MedicalRecordModel> findAll();
    MedicalRecordModel findById(int id);

    @Modifying
	@Query("UPDATE MedicalRecordModel u SET u.name=:#{#update.name},u.birthday=:#{#update.birthday},u.sex=:#{#update.sex},u.admissionDate=:#{#update.admissionDate},u.dischargeDate=:#{#update.dischargeDate}, u.totalBill=:#{#update.totalBill} WHERE u.id=(:id)")
    Integer updateById(@Param("id") int id, @Param("update") MedicalRecordModel update);
}
