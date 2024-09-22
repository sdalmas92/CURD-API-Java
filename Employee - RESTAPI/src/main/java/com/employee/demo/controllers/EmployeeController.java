package com.employee.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.demo.entities.Employee;
import com.employee.demo.repositories.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository repository;
	
	@PostMapping("/save")
	public String save(@RequestBody Employee employee) {		
		repository.save(employee);		
		return employee.getName()+" Saved Successfully"; 
		
	}
	
	@DeleteMapping("/delete/{id}")
	public void save(@PathVariable Integer id) {			
		repository.deleteById(id);		
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Employee employee) {			
		Employee emp = repository.findById(employee.getId()).orElse(null);
		emp.setMobile(employee.getMobile());
		emp.setName(employee.getName());
		emp.setAddress(employee.getAddress());
		repository.save(emp);
	 		
	}
	
	@GetMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable Integer id) {		
		return repository.findById(id).orElse(null);
		
	}
	
	@GetMapping("/allEmployees")
	public List<Employee> getEmployees() {		
				
		return repository.findAll();
		
		
		
	}
	
	
}
