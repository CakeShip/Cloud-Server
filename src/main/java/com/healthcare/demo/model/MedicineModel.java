package com.healthcare.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;
import java.util.List;

import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "MedicineModel") // This tells Hibernate to name the table as User and not User
@DynamicInsert(true)
@DynamicUpdate(true)
public class MedicineModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique=true, nullable=false)
	private Integer id; 

    @Size(max = 255, message = "The medicine name should not exceed 255 characters")
	@Column(name = "medicineName", nullable = false)
    private String medicineName;
    
	@Column(name = "price", nullable = false)
    private float price;
    
    @Column(name = "isArchived")
    private Boolean isArchived;	

    @OneToMany(mappedBy = "medicinemodel",cascade=CascadeType.ALL)
	@Where(clause="isArchived=false")
	private List<DiseaseModel> disease;

	public void setMedicines(List<DiseaseModel> disease)
    {
    	disease.forEach( entity -> entity.setMedicinemodel(this));
    	this.disease = disease;
    }
}
