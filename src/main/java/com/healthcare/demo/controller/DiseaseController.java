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
import com.healthcare.demo.service.DiseaseServiceImpl;

@RestController
@RequestMapping("/diseases")
@CrossOrigin(value = "http://localhost:4200/")
public class DiseaseController {

	@Autowired // This means to get the bean called userRepository
	// Which is auto-generated by Spring, we will use it to handle the data
	private DiseaseServiceImpl diseaseService;

    @PostMapping(value = "/add") // Map ONLY POST Requests
	public @ResponseBody String add( @RequestBody DiseaseModel model) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		model.setIsArchived(false);
		diseaseService.addDisease(model);
		return "Saved";
	}

	@PostMapping(value = "/update/{id}") // Map ONLY POST Requests
	public @ResponseBody String update( @PathVariable int id, @RequestBody DiseaseModel model) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request
		diseaseService.updateById(id, model);
		return "Saved";
	}

	@GetMapping(path = "/findAll")
	public @ResponseBody List<DiseaseModel> findAll() {
		// This returns a JSON or XML with the users
		return diseaseService.findAll();
	}

	@GetMapping(path = "/{id}")
	public @ResponseBody List<DiseaseModel> id(@PathVariable String id) {
		// This returns a JSON or XML with the users
		try{
			Integer.valueOf(id);
			return diseaseService.findById(Integer.parseInt(id));
		} catch (NumberFormatException e) {
			
			return diseaseService.findByDiseaseNameContaining(id);
		}
	}
}
