package lec11.app04.itfirma;

import java.util.HashSet;

/**
 * Created by danila on 05.11.2016.
 */
public class Menu {
    /**
     * Список сотрудников, работающих над заданным проектом
     */
    public HashSet<Employee> listEmployees(Project project) {
        HashSet<Employee> result = new HashSet<>();
        for (Employee employee : project.getEmployees()) {
            if (!employee.getClass().getSimpleName().equals("Head")) {
                result.add(employee);
            }
        }
        return result;
    }

    /**
     * Список проектов, в которых участвует заданный сотрудник
     */
    public HashSet<Project> listProjectsEmployee(Employee employee) {
        HashSet<Project> result = new HashSet<>();
        result.addAll(employee.getCurrentProjects());
        return result;
    }

    /**
     * Список сотрудников из заданного отдела, не участвующих ни в одном проекте
     */
    public HashSet<Employee> listEmployeesNoProjects(Department department) {
        HashSet<Employee> result = new HashSet<>();
        for (Employee employee : department.getEmployees()) {
            if (employee.getCurrentProjects().isEmpty()) {
                result.add(employee);
            }
        }
        return result;
    }

    /**
     * список сотрудников, не участвующих ни в одном проекте
     */
    public HashSet<Employee> listEmployeesNoProjects() {
        HashSet<Employee> result = new HashSet<>();
        for (Employee employee : HumanResourcesDepartment.getEmployeeList()) {
            if (employee.getCurrentProjects().isEmpty()) {
                result.add(employee);
            }
        }
        return result;
    }

    /**
     * список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)
     */
    public HashSet<Employee> listEmployeeHead(Head head) {
        HashSet<Employee> result = new HashSet<>();
        for (Project project : head.getCurrentProjects()) {
            for (Employee employee : project.getEmployees()) {
                if (!employee.getClass().getSimpleName().equals("Head")) {
                    result.add(employee);
                }
            }
        }
        return result;
    }

    /**
     * список руководителей для заданного сотрудника (по всем проектам, в которых он участвует);
     */
    public HashSet<Head> listHeadEmployee(Employee employee) {
        HashSet<Head> result = new HashSet<>();
        for (Project project : employee.getCurrentProjects()) {
            result.add(project.getProjectManager());
        }
        return result;
    }

    /**
     * список сотрудников, участвующих в тех же проектах, что и заданный сотрудник;
     */
    public HashSet<Employee> listEmployeesInProjectsEmployee(Employee employee) {
        HashSet<Employee> result = new HashSet<>();
        for (Project project : employee.getCurrentProjects()) {
            for (Employee emp : project.getEmployees()) {
                if (!emp.getClass().getSimpleName().equals("Head")) {
                    result.add(emp);
                }
            }
        }
        return result;
    }

    /**
     * список проектов, выполняемых для заданного заказчика;
     */
    public HashSet<Project> listProjectsCustomer(Customer customer) {
        HashSet<Project> result = customer.getCurrentProjects();
        return result;
    }

    /**
     * список сотрудников, участвующих в проектах, выполняемых для заданного заказчика.
     */
    public HashSet<Employee> listEmployeesForCustomer(Customer customer) {
        HashSet<Employee> result = new HashSet<>();
        for (Project project : customer.getCurrentProjects()) {
            for (Employee emp : project.getEmployees()) {
                if (!emp.getClass().getSimpleName().equals("Head")) {
                    result.add(emp);
                }
            }
        }
        return result;
    }
}
