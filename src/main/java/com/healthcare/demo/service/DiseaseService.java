package com.healthcare.demo.service;

import java.util.List;

import com.healthcare.demo.model.DiseaseModel;

public interface DiseaseService {

	public List<DiseaseModel> findAll();
	public void addDisease(DiseaseModel diseaseModel);
	public DiseaseModel findById(int id);
	public void deleteById(int id);
	public DiseaseModel updateById(int id, DiseaseModel diseaseModel);
}
