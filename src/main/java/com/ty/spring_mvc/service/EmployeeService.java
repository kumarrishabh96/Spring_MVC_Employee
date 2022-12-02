package com.ty.spring_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ty.spring_mvc.dao.EmployeeDao;
import com.ty.spring_mvc.dto.Employee;

@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;

	public Employee saveEmployee(Employee employee) {
		employeeDao.saveEmployee(employee);
		return employee;
	}

	public Employee getEmployeeByEmail(Employee employee) {
		Employee receivedEmployee = employeeDao.getEmployeeByEmail(employee.getEmail());
		if (employee.getPassword().equals(receivedEmployee.getPassword())) {
			return receivedEmployee;
		} else
			return null;
	}

	public List<Employee> getAllEmployee() {
		return employeeDao.getAllEmployee();
	}

	public void deleteEmployee(int id) {
		employeeDao.deleteEmployee(id);
	}

	public Employee getEmployeeById(int id) {

		return employeeDao.findEmployeeById(id);
	}

	public void updateEmployee(Employee employee) {
		employeeDao.updateEmployee(employee);
	}
}