package com.healthcare.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.demo.model.MedicineModel;
import com.healthcare.demo.repository.MedicineRepository;
import com.healthcare.demo.service.MedicineService;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private MedicineRepository medicineRepository;

   
	@Override
	public List<MedicineModel> findAll() {
		List<MedicineModel> list = new ArrayList<>();
		medicineRepository.findAll().iterator().forEachRemaining(x -> {
			if(!(x.getIsArchived())){
				list.add(x);
			}
		});
		return list;
	}
    
    
	@Override
	public void addMedicine(MedicineModel medicineName) {
		medicineRepository.save(medicineName);
    }
    
	@Override
	public MedicineModel findById(int id) {
		return medicineRepository.findById(id);
	}
	@Override
	public void deleteById(int id) {
		MedicineModel model = medicineRepository.findById(id);
		model.setIsArchived(true);
		medicineRepository.save(model);
	}
	@Override
	public void restoreById(int id) {
		MedicineModel model = medicineRepository.findById(id);
		model.setIsArchived(false);
		medicineRepository.save(model);
	}
	@Override
	@Transactional(rollbackOn = Exception.class)
	public Integer updateById(int id, MedicineModel update) {
		return medicineRepository.updateMedicineById(id, update);
	}
	@Override
	public List<MedicineModel> findByMedicineNameContaining(String medicineName) {
		return medicineRepository.findByMedicineNameContaining(medicineName);
	}
}
