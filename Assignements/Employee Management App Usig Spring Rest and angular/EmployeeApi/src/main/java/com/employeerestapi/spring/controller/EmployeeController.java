package com.employeerestapi.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeerestapi.spring.model.Employee;
import com.employeerestapi.spring.service.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {
	 @Autowired
	   private EmployeeService empService;
	 
	   /*---Add new book---*/
	   @PostMapping("/employee")
	   public ResponseEntity<?> save(@RequestBody Employee emp) {
		  System.out.println("the json value of emp is :::::: "+emp);
	      long id = empService.save(emp);
	      return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
	   }
	   
	   /*---Get a book by id---*/
	   @GetMapping("/employee/{id}")
	   public ResponseEntity<Employee> get(@PathVariable("id") long id) {
	      Employee emp = empService.get(id);
	      return ResponseEntity.ok().body(emp);
	   }
	 
	   /*---get all books---*/
	   @GetMapping("/employee")
	   public ResponseEntity<List<Employee>> list() {
	      List<Employee> books = empService.list();
	      return ResponseEntity.ok().body(books);
	   }
	 
	   /*---Update a book by id---*/
	   @PutMapping("/employee/{id}")
	   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Employee emp) {
	      empService.update(id, emp);
	      return ResponseEntity.ok().body("Employee has been updated successfully.");
	   }
	 
	   /*---Delete a book by id---*/
	   @DeleteMapping("/employee/{id}")
	   public ResponseEntity<?> delete(@PathVariable("id") long id) {
	      empService.delete(id);
	      return ResponseEntity.ok().body("Employee has been deleted successfully.");
	   }

}
