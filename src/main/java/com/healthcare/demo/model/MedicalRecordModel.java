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
	@Column(name = "Name", nullable = false)
	private String Name;

	@Column(name = "Birthday", nullable = false)
	private Date Birthday;

	@Size(max = 255, message = "The patient name should not exceed 255 characters")
	@Column(name = "Sex")
	private String Sex;

	@Column(name = "Admission_Date", nullable = false)
	private Date Admission_Date;

	@Column(name = "Discharge_Date")
	private Date Discharge_Date;

	@ManyToOne
	@JoinColumn(name = "Diseases", nullable = false)
	private MedicineModel Diseases;

	@Column(name = "TotalBill", nullable = false)
	private float TotalBill;
	
    @Column(name = "isArchived")
    private Boolean isArchived;
}
