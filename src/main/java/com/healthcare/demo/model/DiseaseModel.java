package com.healthcare.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "disease") // This tells Hibernate to name the table as User and not User
@DynamicInsert(true)
@DynamicUpdate(true)
public class DiseaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "disease_id",unique=true, nullable=false)
	private Integer id; 

	@Size(max = 255, message = "The disease name should not exceed 255 characters")
	@Column(name = "disease_name", nullable = false)
	private String DiseaseName;
	
	@ManyToOne
	@JoinColumn(name = "medicine_id", nullable = false)
	private MedicineModel Medicines;
}
