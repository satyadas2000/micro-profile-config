package com.howtodoinjava.example.employee.controller;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.howtodoinjava.example.employee.beans.Employee;

@RestController
public class EmployeeServiceController {
	
	
	private static final Map<Integer, Employee> employeeData = new HashMap<Integer, Employee>() {
		/**
		 * 
		 */
		private static final long serialVersionUID = -3970206781360313502L;

		{
			try{
			put(111,new Employee(111,"Employee1"));
			put(222,new Employee(222,"Employee2"));
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
 
    };
 
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	ProfileServiceClient profileService;
	
    @RequestMapping(value = "/findEmployeeDetails/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployeeDetails(@PathVariable int employeeId) {
        System.out.println("Getting Employee details for " + employeeId);
        String addrmsg = restTemplate.getForObject("http://localhost:8080/v2/welcome", String.class);
        Employee employee = employeeData.get(employeeId);
        
        if (employee == null) {
            
        	employee = new Employee(0, "N/A");
            
        }
        employee.setName(addrmsg);
        return employee;
    }
    @RequestMapping(value = "/findEmployeeDetails/v1/{employeeId}", method = RequestMethod.GET)
    public Employee getEmployeeDetails1(@PathVariable int employeeId) {
        System.out.println("Getting Employee details for " + employeeId);
        String addrmsg = profileService.getDataBaseConnectionDetails();
        Employee employee = employeeData.get(employeeId);
        
        if (employee == null) {
            
        	employee = new Employee(0, "N/A");
            
        }
        employee.setName(addrmsg);
        return employee;
    }

}
