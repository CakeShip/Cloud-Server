package com.healthcare.demo.service;

import java.util.List;

import com.healthcare.demo.model.MedicalRecordModel;

public interface MedicalRecordService {

	public List<MedicalRecordModel> findAll();
	public void addMedicalRecord(MedicalRecordModel diseaseModel);
	public MedicalRecordModel findById(int id);
	public void deleteById(int id);
	public void restoreById(int id);
	public MedicalRecordModel updateById(int id, MedicalRecordModel diseaseModel);
}
