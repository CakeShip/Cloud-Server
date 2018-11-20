package com.healthcare.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "medicine") // This tells Hibernate to name the table as User and not User
@DynamicInsert(true)
@DynamicUpdate(true)
public class MedicineModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medicine_id",unique=true, nullable=false)
	private Integer id; 

    @Size(max = 255, message = "The medicine name should not exceed 255 characters")
	@Column(name = "medicine_name", nullable = false)
    private String MedicineName;
    
	@Column(name = "price", nullable = false)
    private float Price;
}
