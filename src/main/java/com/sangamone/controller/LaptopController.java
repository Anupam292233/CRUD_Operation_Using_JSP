package com.sangamone.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sangamone.entity.Laptop;
import com.sangamone.repository.LaptopRepository;

@Controller
public class LaptopController {
	
	@Autowired
	private LaptopRepository laptopRepo;
	
	@GetMapping("/")
	public String Testing() {
		return "index";
	}
	
	@GetMapping("/register")
	public String register() {
		return "product";
	}
	
	@GetMapping("/updateData")
	public String updateData() {
		return "updateData";
	}
	
	@PostMapping("/saveProduct")
	@ResponseBody
	public String saveData(Laptop laptop) {
		laptopRepo.save(laptop);
		return "Data saved successfully";
	}
	
	@GetMapping("/getLaptop/{id}")
	public ResponseEntity<Laptop> getLaptopById(@PathVariable long id) {
	    Optional<Laptop> laptop = laptopRepo.findById(id);
	    if(laptop.isPresent()) {
	    	return new ResponseEntity<Laptop>(laptop.get(),HttpStatus.FOUND);
	    } else {
	    	return new ResponseEntity<Laptop>(laptop.get(),HttpStatus.NOT_FOUND);
	    }
	   
	}
	
	@GetMapping("/findAllData")
	public ResponseEntity<List<Laptop>> getAllData() {
		   List<Laptop> findAll = laptopRepo.findAll();
		   if(findAll.isEmpty()) {
			   return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		   }
		   else  {
			   return new ResponseEntity<>(HttpStatus.OK);
		   }
	}
	
	@PutMapping("/updateData")
	@ResponseBody
	public String updateData(@RequestBody Laptop laptop) {
		Laptop laptop1 = laptopRepo.save(laptop);
		return "Updated successfully";
	}
	
	@DeleteMapping("/deleteData/{id}")
	@ResponseBody
	public String deleteData(@PathVariable Long id) {
		Optional<Laptop> findById = laptopRepo.findById(id);
		Laptop laptop = findById.get();
		if (laptop != null) {
			laptopRepo.delete(laptop);
		}
		return "Data deleted successfully";
	}
}
