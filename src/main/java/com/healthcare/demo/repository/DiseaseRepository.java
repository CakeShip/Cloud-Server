package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.model.DiseaseModel;
import com.healthcare.demo.model.MedicineModel;

@Repository
public interface DiseaseRepository extends JpaRepository<DiseaseModel, Integer> {
    List<DiseaseModel> findAll();
    DiseaseModel findById(int id);
    List<DiseaseModel> findByDiseaseNameContaining(String diseaseName);
   
    @Modifying
    @Query("UPDATE DiseaseModel u SET u.diseaseName=:#{#update.diseaseName}, u.medicinemodel=:#{#update.medicinemodel} WHERE u.id=(:id)")
    Integer updateById(@Param("id") int id, @Param("update") DiseaseModel update);

    @Modifying
    @Query("DELETE FROM DiseaseModel u WHERE u.id=(:dis_id) AND u.medicinemodel=(:med)")
    Integer deleteMedicineById(@Param("dis_id") int dis_id, @Param("med") MedicineModel med);
}
