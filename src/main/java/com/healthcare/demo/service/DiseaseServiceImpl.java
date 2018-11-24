package com.healthcare.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.demo.model.DiseaseModel;
import com.healthcare.demo.repository.DiseaseRepository;
import com.healthcare.demo.service.DiseaseService;

@Service
public class DiseaseServiceImpl implements DiseaseService {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private DiseaseRepository diseaseRepository;

   
	@Override
	public List<DiseaseModel> findAll() {
		List<DiseaseModel> list = new ArrayList<>();
		diseaseRepository.findAll().iterator().forEachRemaining(list::add);
		return list;
	}
    
    
	@Override
	public void addDisease(DiseaseModel diseasemodel) {
		diseaseRepository.save(diseasemodel);
    }
    
	@Override
	public DiseaseModel findById(int id) {
		return diseaseRepository.findById(id);
	}

	@Override
	public void deleteById(int id) {
		DiseaseModel model = diseaseRepository.findById(id);
		model.setIsArchived(true);
		diseaseRepository.save(model);
	}

	@Override
	public void restoreById(int id) {
		DiseaseModel model = diseaseRepository.findById(id);
		model.setIsArchived(false);
		diseaseRepository.save(model);
	}

	@Override
	public Integer updateById(int id, DiseaseModel update) {
		return diseaseRepository.updateById(id, update);
	}

	@Override
	public List<DiseaseModel> findbyDiseaseName(String diseaseName){
		return diseaseRepository.findByDiseaseName(diseaseName);
	}
}
