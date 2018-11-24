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

// //	User deleteDiseaseModelById(int id);
// 	@Query("UPDATE DiseaseModel u SET u.isArchived=true WHERE u.id=(:id)")
// 	User deleteDiseaseModelById(@Param("id") int id);

// //	User findDiseaseModelById(int id);
// 	@Query("SELECT u FROM DiseaseModel u WHERE u.id=(:id)")
// 	User findDiseaseModelById(@Param("id") int id);

// //	User updateDiseaseModelDetailsById(int id, User update_person);
// 	@Query("UPDATE DiseaseModel u SET u.DiseaseName=:#{#update.DiseaseName},u.medicine=:#{#update.medicine} WHERE u.id=(:id)")
// 	User updateDiseaseModelDetailsById(@Param("id") int id, @Param("update") DiseaseModel update);
	
// //	User findDiseaseModelByName(int id, User update_person);
// 	@Query("SELECT u FROM DiseaseModel u WHERE u.DiseaseName LIKE (:name)")
// 	User findDiseaseModelByName(@Param("name") String name);

    List<DiseaseModel> findAll();
    List<DiseaseModel> findById(int id);
    List<DiseaseModel> findByDiseaseNameContaining(String diseaseName);

    @Query("UPDATE DiseaseModel u SET u.diseaseName=:#{#update.diseaseName}, u.medicinemodel=:#{#update.medicinemodel} WHERE u.id=(:id)")
    DiseaseModel updateById(@Param("id") int id, @Param("update") DiseaseModel update);
}
