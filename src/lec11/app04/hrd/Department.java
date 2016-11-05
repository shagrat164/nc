package lec11.app04.hrd;

// отдел

import java.util.HashSet;

public class Department {
    private String name;
    private HashSet<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee addEmployee) {
        this.employees.add(addEmployee);
        addEmployee.setDepartment(this);
    }

    public void removeEmployee(HashSet<Employee> employees) {
        this.employees = employees;
    }
}
