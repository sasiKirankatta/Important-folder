package com.infinite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinite.model.Employee;
import com.infinite.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository empRepository;

	// CREATE
	public Employee createEmployee(Employee emp) {
		return empRepository.save(emp);
	}

	// READ
	public List<Employee> getEmployees() {
		return empRepository.findAll();
	}

	public Employee findById(Integer id) {
		Optional<Employee> userResult = empRepository.findById(id);
		Employee emp = null;
		if (userResult.isPresent()) {
			emp = userResult.get();
		}
		return emp;
	}

	public void deleteEmployee(Employee emp) {
		empRepository.delete(emp);
	}
}