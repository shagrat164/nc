package lec11.app01;

import java.util.TreeSet;

/**
 * Created by student on 01.11.16.
 */

public class app {
    public static void main(String... args) {
        Person person1 = new Person("Моисеев", "Иван", "Артёмович");
        Person person2 = new Person("Семёнов", "Симён", "Андреевич");
        Person person3 = new Person("Зюзин", "Вениамин", "Васильевич");
        Person person4 = new Person("Моисеев", "Сергей", "Артёмович");

//        PersonComparator personComparator = new PersonComparator();
//        TreeSet<Person> personTreeSet = new TreeSet<Person>(personComparator);
        TreeSet<Person> personTreeSet = new TreeSet<Person>();

        personTreeSet.add(person1);
        personTreeSet.add(person2);
        personTreeSet.add(person3);
        personTreeSet.add(person4);

        for (Person person:personTreeSet) {
            System.out.print(person.getLastName() + " " + person.getFirstName() + " " + person.getMiddleName());
            System.out.println();
        }
    }
}