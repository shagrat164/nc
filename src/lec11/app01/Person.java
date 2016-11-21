package lec11.app01;

/**
 * Created by student on 01.11.16.
 */
public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String middleName;

    public Person(String lastName, String firstName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public int compareTo(Person person) {
        if (getLastName().compareTo(person.getLastName()) != 0) {
            return getLastName().compareTo(person.getLastName());
        }
        if (getFirstName().compareTo(person.getFirstName()) != 0) {
            return getFirstName().compareTo(person.getFirstName());
        }
        return getMiddleName().compareTo(person.getMiddleName());
    }
}
