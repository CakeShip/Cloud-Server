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

import com.healthcare.demo.model.MedicineModel;
import com.healthcare.demo.model.MedicalRecordModel;
import com.healthcare.demo.service.MedicineServiceImpl;
import com.healthcare.demo.service.MedicalRecordServiceImpl;

@RestController
@RequestMapping("/medicines")
@CrossOrigin(value = "http://localhost:4200/")
public class MedicineController {

	@Autowired
	private MedicineServiceImpl medicineService;
	@Autowired
	private MedicalRecordServiceImpl medicalRecordServiceImpl;
	

	@PostMapping(value = "/add")
	public @ResponseBody String add(@RequestBody MedicineModel model) {
		model.setIsArchived(false);
		medicineService.addMedicine(model);
		return "Saved";
	}

	@PostMapping(value = "/update/{id}")
	public @ResponseBody Integer update(@PathVariable int id, @RequestBody MedicineModel model) {
		return medicineService.updateById(id, model);
	}

	@PostMapping(value = "/restore/{id}")
	public @ResponseBody String restore(@PathVariable int id) {
		medicineService.restoreById(id);
		return "Saved";
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody List<MedicineModel> findAll() {
		return medicineService.findAll();
	}

	@GetMapping(path = "/{id}")
	public @ResponseBody MedicineModel id(@PathVariable int id) {
		return medicineService.findById(id);
	}

	@GetMapping(path = "/search/{name}")
    public @ResponseBody List<MedicalRecordModel> search(@PathVariable String name) {
        if("*".equals(name)){
            return medicalRecordServiceImpl.findAll();
        } else {
            return medicalRecordServiceImpl.findByNameContaining(name);
        }
    }

	@PostMapping(value = "/delete/{id}")
	public @ResponseBody String deletemag(@PathVariable int id) {
		medicineService.deleteById(id);
		return "Saved";
	}
}
