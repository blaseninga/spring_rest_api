package com.project.spring.rest;

import com.project.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@ComponentScan(basePackages = "com.project.spring")
public class Communication {
    @Autowired
    private RestTemplate restTemplate;
    private final String url = "http://localhost:8080/spring_course_rest/api/employee";
    private final String url1 = "http://localhost:8080/spring_course_rest/api/employees";
    public List<Employee> getAllEmployees(){
        ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Employee>>() {});
        List<Employee> allEmployees = responseEntity.getBody();
        return allEmployees;
    }
    public Employee getEmployee(int id){
        Employee employee = restTemplate.getForObject(url1 + "/" + id, Employee.class);
        return  employee;
    }
    public void saveEmployee(Employee employee){
        int id = employee.getId();
        if (id == 0) {
            ResponseEntity<String> responseEntity = restTemplate.postForEntity(url1, employee, String.class);
            System.out.println("New employee was added in DB");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(url1, employee);
            System.out.println("Employee with ID " + id + " was updated");
        }
    }
    public void deleteEmployee(int id){
        restTemplate.delete(url1 + "/" + id);
        System.out.println("Employee with ID " + id + " was deleted");
    }
}
