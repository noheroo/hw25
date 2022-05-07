package pro.sky.java.course2.hw25.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hw25.data.Employee;
import pro.sky.java.course2.hw25.exeptions.EmployeeAlreadyAddedException;
import pro.sky.java.course2.hw25.exeptions.EmployeeNotFoundException;
import pro.sky.java.course2.hw25.exeptions.ListIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private static final int size = 2;
    List<Employee> employees = new ArrayList<>();

    public List<Employee> printEmployees() {
        return employees;
    }

    public void addEmployee(String lastName, String firstName) {

        if (ListIsFull(size)) {
            throw new ListIsFullException();
        }
        Employee employee = new Employee(lastName, firstName);
        if (isSame(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
    }

    public Employee removeEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        int num = isFound(employee);
        if (num == -1) {
            throw new EmployeeNotFoundException();
        }
        Employee employeeDel = new Employee(employees.get(num).getLastName(), employees.get(num).getFirstName());
        employees.remove(num);
        return employeeDel;
    }

    public Employee findEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        int num = isFound(employee);
        if (num == -1) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(num);
    }

    private boolean ListIsFull(int size) {
        return employees.size() >= size;
    }

    private boolean isSame(Employee employee) {
        for (Employee value : employees) {
            if (value != null && value.equals(employee)) {
                return true;
            }
        }
        return false;
    }

    private int isFound(Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i) != null && employees.get(i).equals(employee)) {
                return i;
            }
        }
        return -1;
    }
}


