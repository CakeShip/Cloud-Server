package com.healthcare.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.demo.model.DiseaseModel;
import com.healthcare.demo.model.MedicineModel;
import com.healthcare.demo.service.DiseaseServiceImpl;
import com.healthcare.demo.service.MedicineServiceImpl;

@RestController
@RequestMapping("/diseases")
@CrossOrigin(value = "http://localhost:4200/")
public class DiseaseController {

	@Autowired
	private DiseaseServiceImpl diseaseService;

	@Autowired
	private MedicineServiceImpl medicineService;

	@PostMapping(value = "/add")
	public @ResponseBody String add(@RequestBody DiseaseModel model) {
		model.setIsArchived(false);
		diseaseService.addDisease(model);
		return "Saved";
	}

	@PostMapping(value = "/update/{id}")
	public @ResponseBody Integer update(@PathVariable int id, @RequestBody DiseaseModel model) {
		return diseaseService.updateById(id, model);
	}

	@PostMapping(value = "/restore/{id}")
	public @ResponseBody String restore(@PathVariable int id) {
		diseaseService.restoreById(id);
		return "Saved";
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody List<DiseaseModel> findAll() {
		return diseaseService.findAll();
	}

	@GetMapping(path = "/{id}")
	public @ResponseBody DiseaseModel id(@PathVariable int id) {
		return diseaseService.findById(id);
	}

	@GetMapping(path = "/search/{name}")
	public @ResponseBody List<DiseaseModel> findByName(@PathVariable String name) {
		return diseaseService.findByDiseaseNameContaining(name);
	}

	@PostMapping(value = "/med/delete/{dis_id}/{med_id}")
	public @ResponseBody String deleteMedById(@PathVariable("dis_id") int dis_id, @PathVariable("med_id") int med_id) {
		diseaseService.deleteMediById(dis_id, med_id);
		return "deleted";
	}	

	@PostMapping(value = "/delete/{id}")
	public @ResponseBody String deletemag(@PathVariable int id) {
		diseaseService.deleteById(id);
		return "Saved";
	}
}