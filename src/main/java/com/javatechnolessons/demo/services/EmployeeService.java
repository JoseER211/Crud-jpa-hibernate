package com.javatechnolessons.demo.services;

import com.javatechnolessons.demo.model.Employee;
import com.javatechnolessons.demo.repositories.IEmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class EmployeeService {
    @Autowired

    IEmployeeJpaRepository IEmployeeJpaRepository;

    public ArrayList<Employee> getEmployee() {
        return (ArrayList<Employee>)  IEmployeeJpaRepository.findAll();

    }

    public Employee saveEmployee(Employee employee) {
        return  IEmployeeJpaRepository.save(employee);
    }

    public Optional<Employee> getById(Long id) {
        return IEmployeeJpaRepository.findById(id);
    }

    public boolean deleteEmployee(Long id) {
        try {
            IEmployeeJpaRepository.deleteById(id);
            return true;
        }
        catch (Exception err) {
            return false;
        }
    }

}
