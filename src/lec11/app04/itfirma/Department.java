package lec11.app04.itfirma;

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

    void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    void removeEmployee(Employee employee) {
        this.employees.remove(employee);
    }

    @Override
    public String toString() {
        return name;
    }
}
