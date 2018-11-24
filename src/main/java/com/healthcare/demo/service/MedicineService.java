package com.healthcare.demo.service;

import java.util.List;

import com.healthcare.demo.model.MedicineModel;

public interface MedicineService {

	public List<MedicineModel> findAll();
	public void addMedicine(MedicineModel medicineModel);
	public MedicineModel findById(int id);
	public MedicineModel deleteById(int id);
	public MedicineModel updateById(int id, MedicineModel medicineModel);
	public List<MedicineModel> findByMedicineNameContaining(String medicineName);
}
