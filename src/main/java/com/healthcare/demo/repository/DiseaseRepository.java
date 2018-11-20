package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthcare.demo.model.*;

@Repository
public interface DiseaseRepository extends JpaRepository<DiseaseModel, Integer> {

//	User deleteDiseaseById(int id);
	@Query("UPDATE DiseaseModel u SET u.isArchived=true WHERE u.id=(:id)")
	User deleteDiseaseById(@Param("id") int id);

//	User findDiseaseById(int id);
	@Query("SELECT u FROM DiseaseModel u WHERE u.id=(:id)")
	User findDiseaseById(@Param("id") int id);

//	User updateDiseaseDetailsById(int id, User update_person);
	@Query("UPDATE DiseaseModel u SET u.DiseaseName=:#{#update.DiseaseName},u.medicine=:#{#update.disease.medicine} WHERE u.id=(:id)")
	User updateDiseaseDetailsById(@Param("id") int id, @Param("update") DiseaseModel update);
	
//	User findPersonDetailsByName(int id, User update_person);
	@Query("SELECT u FROM DiseaseModel u WHERE u.DiseaseName LIKE (:name)")
	User findPersonDetailsByName(@Param("name") String name);
}
