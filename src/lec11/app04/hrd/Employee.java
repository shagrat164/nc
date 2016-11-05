package lec11.app04.hrd;

// сотрудник

import java.util.Date;
import java.util.HashSet;

public class Employee extends Person {
    private static long id = 0;
    private long employeeId;
    private int age;
    private Date birthday;
    private Date dateEmployment;
    private Department department;
    private String position;
    private HashSet<Project> currentProjects;
    private HashSet<Project> completedProjects;

    Employee(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
        id+=1;
        this.employeeId = id;
        currentProjects = new HashSet<>();
        completedProjects = new HashSet<>();
        dateEmployment = new Date();
    }

    /**
     * Возвращает id сотрудника
     */
    public long getId() {
        return employeeId;
    }

    /**
     * Возвращает возраст сотрудника
     */
    public int getAge() {
        return age;
    }

    /**
     * Возвращает дату рождения сотрудника
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * Устанавливает дату рождения сотрудника
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * Возвращает дату приёма на работу в компанию
     */
    public Date getDateEmployment() {
        return dateEmployment;
    }

    /**
     * Возвращает время работы в компании
     */
    public Date getWorkingHours() {
        return dateEmployment;
    }

    /**
     * Возвращает отдел в котором работает сотрудник
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Устанавливает сотруднику отдел
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Возвращает должность
     */
    public String getPosition() {
        return position;
    }

    /**
     * Устанавливает должность
     */
    public void setPosition(String position) {
        this.position = position;
    }

    public HashSet<Project> getCurrentProjects() {
        return currentProjects;
    }

    public void addCurrentProjects(Project project) {
        currentProjects.add(project);
    }

    public void removeCurrentProjects(Project project) {
        currentProjects.remove(project);
    }

    public HashSet<Project> getCompletedProjects() {
        return completedProjects;
    }

    public void addCompletedProjects(Project projects) {
        completedProjects.add(projects);
    }

    public boolean equals(Employee employee) {
        if (this.getId() == employee.getId()) {
            return true;
        }
        return false;
    }
}
