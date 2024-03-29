package com.infinite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.infinite.model.Employee;
import com.infinite.service.EmployeeService;

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	// creating
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee createEmployee(@RequestBody Employee emp) {
		System.out.println("creation of table employee ");
		return employeeService.createEmployee(emp);
	}

	// to show all the data
	@RequestMapping(value = "/reademployees", method = RequestMethod.GET)
	public List<Employee> readEmployees() {
		System.out.println("read of table employee ");
		return employeeService.getEmployees();
	}

	// @PathVariable
	// http://localhost:8080/reademployees/2
	@RequestMapping(value = "/reademployees/{id}", method = RequestMethod.GET)
	public Employee readEmployeesid(@PathVariable int id) {
		System.out.println("read of table emplo ");
		Employee emp = employeeService.findById(id);
		System.out.println("read of table yee ");
		return emp;
	}

	// @RequestParam
	// http://localhost:8080/reademployee?id=10
	@RequestMapping(value = "/reademployee", method = RequestMethod.GET)
	public Employee readEmployeesid1(@RequestParam("id") int id) {
		System.out.println("read of table emplo ");
		Employee emp = employeeService.findById(id);
		System.out.println("read of table yee ");
		return emp;
	}

	// delete the data employee details
	@RequestMapping(value = "/deleteemployees/{id}", method = RequestMethod.DELETE)
	public Employee deleteEmployeesid(@PathVariable int id) {
		Employee emp = employeeService.findById(id);
		employeeService.deleteEmployee(emp);
		return emp;
	}

	// to update employee details
	@PutMapping("/update/{id}")
	public Employee updateemp(@PathVariable Integer id, @RequestBody Employee empDetail) {
		Employee emp = employeeService.findById(id);
		emp.setFname(empDetail.getFname());
		emp.setLname(empDetail.getLname());
		emp.setDepartment(empDetail.getDepartment());
		employeeService.createEmployee(emp);
		return emp;
	}
}