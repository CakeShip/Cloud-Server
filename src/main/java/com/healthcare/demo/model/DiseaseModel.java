package com.healthcare.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.persistence.OneToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import java.util.List;
import javax.persistence.FetchType;

import org.hibernate.annotations.Where;

import javax.persistence.CascadeType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "DiseaseModel") // This tells Hibernate to name the table as User and not User
@DynamicInsert(true)
@DynamicUpdate(true)
public class DiseaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",unique=true, nullable=false)
	private Integer id; 

	@Size(max = 255, message = "The disease name should not exceed 255 characters")
	@Column(name = "DiseaseName", nullable = false)
	private String DiseaseName;	

    @Column(name = "isArchived")
    private Boolean isArchived;
	
	@OneToMany(mappedBy = "diseasemodel",cascade=CascadeType.ALL)
	@Where(clause="isArchived=false")
	private List<MedicineModel> medicine;

	public void setMedicines(List<MedicineModel> medicine)
    {
    	medicine.forEach( entity -> entity.setDiseasemodel(this));
    	this.medicine = medicine;
    }
}
