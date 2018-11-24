package com.healthcare.demo.service;

import java.util.List;

import com.healthcare.demo.model.MedicineModel;

public interface MedicineService {

	public List<MedicineModel> findAll();
	public void addMedicine(MedicineModel medicineModel);
	public MedicineModel findById(int id);
	public void deleteById(int id);
	public void restoreById(int id);
	public MedicineModel updateById(int id, MedicineModel medicineModel);
}
