package pro.sky.java.course2.hw25.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.hw25.data.Employee;
import pro.sky.java.course2.hw25.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String lastname, @RequestParam String firstname) {
        employeeService.addEmployee(lastname, firstname);
        return "Employee is added";
    }

    @GetMapping("/remove")
    public Employee deleteEmployee(@RequestParam String lastname, @RequestParam String firstname) {
        return employeeService.removeEmployee(lastname, firstname);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String lastname, @RequestParam String firstname) {
        return employeeService.findEmployee(lastname, firstname);
    }

    @GetMapping("/print")
    public List<Employee> printEmployees() {
        return employeeService.printEmployees();
    }
}
