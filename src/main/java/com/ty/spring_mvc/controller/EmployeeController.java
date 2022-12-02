package com.ty.spring_mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ty.spring_mvc.dto.Employee;
import com.ty.spring_mvc.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("login")
	public ModelAndView getIndex() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employee", new Employee());
		modelAndView.setViewName("login.jsp");
		return modelAndView;
	}

	@RequestMapping("signup")
	public ModelAndView getIndex1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("signup.jsp");
		modelAndView.addObject("employee", new Employee());
		return modelAndView;
	}

	@RequestMapping("saveEmployee")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		employeeService.saveEmployee(employee);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index.jsp");
		return modelAndView;
	}

	@RequestMapping("loginEmployee")
	public ModelAndView loginEmployee(@ModelAttribute Employee employee) {
		Employee employee2 = employeeService.getEmployeeByEmail(employee);
		ModelAndView modelAndView = new ModelAndView();
		if (employee2 != null) {
			modelAndView.addObject("name", employee2.getName());
			modelAndView.addObject("elist", employeeService.getAllEmployee());
			modelAndView.setViewName("view.jsp");
		} else {
			modelAndView.setViewName("login.jsp");
		}
		return modelAndView;
	}

	@RequestMapping("view")
	public ModelAndView getView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("elist", employeeService.getAllEmployee());
		modelAndView.setViewName("view.jsp");
		return modelAndView;
	}

	@RequestMapping("delete")
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(Integer.parseInt(request.getParameter("id")));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view");
		requestDispatcher.forward(request, response);

	}

	@RequestMapping("edit")
	public ModelAndView editEmployee(@RequestParam int id) {
		Employee employee = employeeService.getEmployeeById(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("employee", employee);
		modelAndView.setViewName("edit.jsp");
		return modelAndView;
	}

	@RequestMapping("updateEmployee")
	public void updateEmployee(@ModelAttribute Employee employee, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		employeeService.updateEmployee(employee);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("view");
		requestDispatcher.forward(request, response);
	}

}