package lec11.app04.hrd;

// проект

import java.util.Date;

public class Project {
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private double price;
    private Head projectManager;
    private Customer customer;

    public Project(String name, Head projectManager, Customer customer) {
        this.name = name;
        this.projectManager = projectManager;
        this.customer = customer;
        this.startDate = new Date();
        this.projectManager.addCurrentProjects(this);
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Head getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(Head projectManager) {
        if (projectManager.getId() != this.projectManager.getId()) {
            this.projectManager.removeCurrentProjects(this);
            this.projectManager = projectManager;
            projectManager.addCurrentProjects(this);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
