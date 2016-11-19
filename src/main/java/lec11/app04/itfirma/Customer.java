package lec11.app04.itfirma;

// заказчик

import java.util.HashSet;

public class Customer extends Person {
    private String nameCompany;
    private String phoneNumber;
    private HashSet<Project> currentProjects;
    private HashSet<Project> completedProjects;

    public Customer(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
        currentProjects = new HashSet<>();
        completedProjects = new HashSet<>();
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

    public HashSet<Project> getCurrentProjects() {
        return currentProjects;
    }

    public HashSet<Project> getCompletedProjects() {
        return completedProjects;
    }

    void addCurrentProjects(Project currentProjects) {
        this.currentProjects.add(currentProjects);
    }

    void addCompletedProjects(Project completedProjects) {
        this.currentProjects.remove(completedProjects);
        this.completedProjects.add(completedProjects);
    }
}
