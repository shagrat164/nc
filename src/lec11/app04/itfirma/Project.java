package lec11.app04.itfirma;

// проект

import java.util.HashSet;

public class Project {
    private String name;
    private String description = "";
    private Head projectManager;
    private HashSet<Employee> employees;
    private Customer customer;
    private boolean finish;

    private void setFinish(boolean finish) {
        this.finish = finish;
    }

    public Project(String name, Head projectManager, Customer customer) {
        this.name = name;
        this.projectManager = projectManager;
        this.customer = customer;
        employees = new HashSet<>();
        customer.addCurrentProjects(this);
        projectManager.addCurrentProjects(this);
    }

    public boolean isFinish() {
        return finish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Head getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Head projectManager) {
        if (this.projectManager.equals(projectManager) == false) {
            this.projectManager.removeCurrentProjects(this);
            this.projectManager = projectManager;
            projectManager.addCurrentProjects(this);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public HashSet<Employee> getEmployees() {
        return employees;
    }

    public void addEmployees(Employee employee) {
        this.employees.add(employee);
    }

    public void completeProject() {
        projectManager.addCompletedProjects(this);
        for (Employee employee : employees) {
            employee.addCompletedProjects(this);
        }
        setFinish(true);
        customer.addCompletedProjects(this);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
