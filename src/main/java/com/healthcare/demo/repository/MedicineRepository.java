package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.model.MedicineModel;

@Repository
public interface MedicineRepository extends JpaRepository<MedicineModel, Integer> {
    List<MedicineModel> findAll();
    MedicineModel findById(int id);

    @Modifying
    @Query("UPDATE MedicineModel u SET u.medicineName=:#{#update.medicineName}, u.price=:#{#update.price} WHERE u.id=(:id)")
    Integer updateById(@Param("id") int id, @Param("update") MedicineModel update);

}
