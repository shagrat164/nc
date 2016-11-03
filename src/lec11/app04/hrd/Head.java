package lec11.app04.hrd;

// руководитель

import java.util.Date;
import java.util.HashSet;

public class Head extends Employee {
    private HashSet<Employee> subordinates;

    public Head(String firstName, String lastName, String middleName, String sex) {
        super(firstName, lastName, middleName, sex);
        subordinates = new HashSet<>();
    }

    public HashSet<Employee> getSubordinates() {
        return subordinates;
    }

    public void addSubordinates(Employee employee) {
        subordinates.add(employee);
    }
}
