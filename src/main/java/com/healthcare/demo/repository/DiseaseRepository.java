package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthcare.demo.model.DiseaseModel;

@Repository
public interface DiseaseRepository extends JpaRepository<DiseaseModel, Integer> {
    List<DiseaseModel> findAll();
    DiseaseModel findById(int id);
    List<DiseaseModel> findByDiseaseNameContaining(String diseaseName);

    @Query("UPDATE DiseaseModel u SET u.diseaseName=:#{#update.diseaseName}, u.medicinemodel=:#{#update.medicinemodel} WHERE u.id=(:id)")
    DiseaseModel updateById(@Param("id") int id, @Param("update") DiseaseModel update);

    // @Query("UPDATE DiseaseModel u SET u.isArchived=true WHERE u.id=(:id)")
	// DiseaseModel deleteById(@Param("id") int id);
}
