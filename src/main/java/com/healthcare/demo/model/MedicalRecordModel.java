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

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "MedicalRecordModel") // This tells Hibernate to name the table as User and not User
@DynamicInsert(true)
@DynamicUpdate(true)
public class MedicalRecordModel {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique=true, nullable=false)
	private Integer id; 

	@Size(max = 255, message = "The patient name should not exceed 255 characters")
	@Column(name = "name", nullable = false)
	private String Name;

	@Column(name = "birthday", nullable = false)
	private Date Birthday;

	@Size(max = 255, message = "The patient name should not exceed 255 characters")
	@Column(name = "sex")
	private String Sex;

	@Column(name = "admission_date", nullable = false)
	private Date Admission_Date;

	@Column(name = "discharge_date")
	private Date Discharge_Date;

	@ManyToOne
	@JoinColumn(name = "disease_id", nullable = false)
	private MedicineModel Diseases;

	@Column(name = "total_bill", nullable = false)
	private float TotalBill;
}
