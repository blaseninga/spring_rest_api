package com.project.spring.rest;

import com.project.spring.rest.confihuration.MyConfig;
import com.project.spring.rest.entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import java.util.List;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Communication communication = context.getBean(Communication.class);

        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

//        Employee empByID = communication.getEmployee(1);
//        System.out.println(empByID);
//
//        Employee emp = new Employee("Sveta", "Sokolova", "IT", 1200);
//        emp.setId(8);
//        communication.saveEmployee(emp);
//        communication.deleteEmployee(8);

    }
}
