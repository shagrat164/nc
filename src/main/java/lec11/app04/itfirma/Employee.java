package lec11.app04.itfirma;

// сотрудник

import java.util.HashSet;

public class Employee extends Person {
    private static long id = 0;
    private long employeeId;
    private Department department;
    private String position;
    private HashSet<Project> currentProjects;
    private HashSet<Project> completedProjects;

    public Employee(String firstName, String lastName, String middleName) {
        super(firstName, lastName, middleName);
        id+=1;
        this.employeeId = id;
        currentProjects = new HashSet<>();
        completedProjects = new HashSet<>();
        HumanResourcesDepartment.addEmployeeList(this); // добавление в общий список
    }

    @Override
    protected void finalize() throws Throwable {
        HumanResourcesDepartment.removeEmployeeList(this);
    }

    /**
     * Возвращает id сотрудника
     */
    public long getId() {
        return employeeId;
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
        department.addEmployee(this);
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
        project.addEmployees(this);
    }

    void removeCurrentProjects(Project project) {
        currentProjects.remove(project);
    }

    public HashSet<Project> getCompletedProjects() {
        return completedProjects;
    }

    void addCompletedProjects(Project projects) {
        removeCurrentProjects(projects);
        completedProjects.add(projects);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return employeeId == employee.employeeId;
    }

    @Override
    public int hashCode() {
        return (int) (employeeId ^ (employeeId >>> 32));
    }

    @Override
    public String toString() {
        return "id=" + getId() + " " +
                super.toString() +
                ", department=" + getDepartment() +
                ", position='" + getPosition() + '\'' +
                ", typeObject='" + getClass().getSimpleName() + '\'';
    }
}
