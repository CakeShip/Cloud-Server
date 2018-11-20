package com.healthcare.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.healthcare.demo.model.*;

@Repository
public interface MedicalRecordRepository extends JpaRepository<User, Integer> {
    
}
