package com.javatechnolessons.demo.controllers;

import com.javatechnolessons.demo.model.Employee;
import com.javatechnolessons.demo.model.Role;
import com.javatechnolessons.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping ("/Employee")
public class EmployeeController {

    @Autowired
    EmployeeService EmployeeService;

    @GetMapping()
    public ArrayList<Employee> getEmployee() {
        return EmployeeService.getEmployee();
    }

    @PostMapping()
    public Employee saveEmployee(@RequestBody Employee employee) {
        return this.EmployeeService.saveEmployee(employee);
    }

    @GetMapping(path = "/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return this.EmployeeService.getById(id);
    }


    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        boolean ok = this.EmployeeService.deleteEmployee(id);
        if (ok) {
            return "Se eliminó el usuario con id " + id;
        }
        else {
            return "No pudo eliminar el usuario con id" + id;
        }
    }

}
