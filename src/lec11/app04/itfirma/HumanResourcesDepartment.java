package lec11.app04.itfirma;

import java.util.HashSet;

public class HumanResourcesDepartment {
    private static HashSet<Employee> employeeList = new HashSet<>();

    public static void addEmployeeList(Employee employee) {
        employeeList.add(employee);
    }

    public static void removeEmployeeList(Employee employee) {
        employeeList.remove(employee);
    }

    public static HashSet<Employee> getEmployeeList() {
        return employeeList;
    }
}
