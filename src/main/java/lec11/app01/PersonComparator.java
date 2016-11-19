package lec11.app01;

import java.util.Comparator;

/**
 * Created by student on 01.11.16.
 */
public class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        if (person1.getLastName().compareTo(person2.getLastName()) != 0) {
            return person1.getLastName().compareTo(person2.getLastName());
        }
        if (person1.getFirstName().compareTo(person2.getFirstName()) != 0) {
            return person1.getFirstName().compareTo(person2.getFirstName());
        }
        return person1.getMiddleName().compareTo(person2.getMiddleName());
    }
}