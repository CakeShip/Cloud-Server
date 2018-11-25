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
import com.healthcare.demo.service.MedicineServiceImpl;

@RestController
@RequestMapping("/medicines")
@CrossOrigin(value = "http://localhost:4200/")
public class MedicineController {

	@Autowired
	private MedicineServiceImpl medicineService;

	@PostMapping(value = "/add")
	public @ResponseBody String add(@RequestBody MedicineModel model) {
		model.setIsArchived(false);
		medicineService.addMedicine(model);
		return "Saved";
	}

	@PostMapping(value = "/update")
	public @ResponseBody String update(@RequestParam("id") int id, @RequestBody MedicineModel model) {
		medicineService.updateById(id, model);
		return "Saved";
	}

	@PostMapping(value = "/delete")
	public @ResponseBody String delete(@RequestParam("id") int id) {
		medicineService.deleteById(id);
		return "Saved";
	}

	@PostMapping(value = "/restore")
	public @ResponseBody String restore(@RequestParam("id") int id) {
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
	public @ResponseBody List<MedicineModel> search(@PathVariable String name) {
		return medicineService.findByMedicineNameContaining(name);
	}

	@PostMapping(value = "/delete/{id}")
	public @ResponseBody String deletemag(@PathVariable int id) {
		medicineService.deleteById(id);
		return "Saved";
	}
}
