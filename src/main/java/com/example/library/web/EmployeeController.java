package com.example.library.web;

import com.example.library.model.Department;
import com.example.library.model.Employee;
import com.example.library.model.dto.EmployeeDto;
import com.example.library.repositories.DepartmentRepository;
import com.example.library.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final DepartmentRepository departmentRepo;
    private final EmployeeRepository employeeRepository;

    @GetMapping
    public String showEmployeeForm() {
        return "employee";
    }

    @ModelAttribute(value = "departments")
    public Iterable<Department> getAllDepartments() {
        return departmentRepo.findAll();
    }

    @ModelAttribute(value = "employee")
    public EmployeeDto employee() {
        return new EmployeeDto();
    }

    @PostMapping
    public String processEmployee(@Valid @ModelAttribute(value = "employee") EmployeeDto employee, Errors errors) {
        if (errors.hasErrors()) {
            return "scard";
        }

        log.info("Processing employee: {}", employee);

        Employee employeeToSave = new Employee();
        employeeToSave.setFirstName(employee.getFirstName());
        employeeToSave.setLastName(employee.getLastName());
        employeeToSave.setDepartment(departmentRepo.findById(employee.getDepartmentId()).orElseThrow(NullPointerException::new));
        employeeRepository.save(employeeToSave);

        return "redirect:/employee";
    }
}
