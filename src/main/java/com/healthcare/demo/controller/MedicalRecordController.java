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

import com.healthcare.demo.model.MedicalRecordModel;
import com.healthcare.demo.service.MedicalRecordServiceImpl;

@RestController
@RequestMapping("/mr")
@CrossOrigin(value = "http://localhost:4200/")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordServiceImpl medicalRecordServiceImpl;

    @PostMapping(value = "/add")
    public @ResponseBody String add(@RequestBody MedicalRecordModel model) {
        model.setIsArchived(false);
        medicalRecordServiceImpl.addMedicalRecord(model);
        return "Saved";
    }

    @PostMapping(value = "/update")
    public @ResponseBody String update(@RequestParam("id") int id, @RequestBody MedicalRecordModel model) {
        medicalRecordServiceImpl.updateById(id, model);
        return "Saved";
    }

    @PostMapping(value = "/delete")
    public @ResponseBody String delete(@RequestParam("id") int id) {
        medicalRecordServiceImpl.deleteById(id);
        return "Saved";
    }

    @PostMapping(value = "/restore")
    public @ResponseBody String restore(@RequestParam("id") int id) {
        medicalRecordServiceImpl.restoreById(id);
        return "Saved";
    }

    @GetMapping(path = "/findAll")
    public @ResponseBody List<MedicalRecordModel> findAll() {
        return medicalRecordServiceImpl.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody MedicalRecordModel id(@PathVariable int id) {
        return medicalRecordServiceImpl.findById(id);
    }

    @GetMapping(path = "/search/{name}")
	public @ResponseBody List<MedicalRecordModel> search(@PathVariable String name) {
		return medicalRecordServiceImpl.findByNameContaining(name);
	}
}
