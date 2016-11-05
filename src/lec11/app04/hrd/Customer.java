package lec11.app04.hrd;

// заказчик

import java.util.HashSet;

public class Customer extends Person {
    private String nameCompany;
    private String phoneNumber;
    private String lineOfBusiness;
    private HashSet<Project> currentProjects;
    private HashSet<Project> completedProjects;

    public Customer(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLineOfBusiness() {
        return lineOfBusiness;
    }

    public void setLineOfBusiness(String lineOfBusiness) {
        this.lineOfBusiness = lineOfBusiness;
    }

    public HashSet<Project> getCurrentProjects() {
        return currentProjects;
    }

    public void addCurrentProjects(Project currentProjects) {
        this.currentProjects.add(currentProjects);
    }

    public HashSet<Project> getCompletedProjects() {
        return completedProjects;
    }

    public void addCompletedProjects(Project completedProjects) {
        this.currentProjects.remove(completedProjects);
        this.completedProjects.add(completedProjects);
    }
}
