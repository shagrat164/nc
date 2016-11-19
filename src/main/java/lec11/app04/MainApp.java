package lec11.app04;

import lec11.app04.itfirma.*;

public class MainApp {
    public static void main(String[] args) {

        // отделы
        Department depProgrammers = new Department("программисты");
        Department depDesigners = new Department("дизайнеры");
        Department depAnalysts = new Department("аналитики");
        Department depManagement = new Department("менеджмент");
        Department depFinance = new Department("финансы");
        Department depProject = new Department("проекты");

        // сотрудники
        Employee employee1 = new Employee("Иванов", "Иван", "Иванович");
        employee1.setDepartment(depProgrammers);
        employee1.setPosition("программист");

        Employee employee2 = new Employee("Орехова", "Татьяна", "Романовна");
        employee2.setDepartment(depDesigners);
        employee2.setPosition("дизайнер");

        Employee employee3 = new Employee("Журавлёва", "Анастасия", "Олеговна");
        employee3.setDepartment(depProgrammers);
        employee3.setPosition("программист");

        Employee employee4 = new Employee("Сорокина", "Людмила", "Лукьевна");
        employee4.setDepartment(depDesigners);
        employee4.setPosition("дизайнер");

        Employee employee5 = new Employee("Буров", "Александр", "Онисимович");
        employee5.setDepartment(depAnalysts);
        employee5.setPosition("старший аналитик");

        Employee employee6 = new Employee("Некрасов", "Егор", "Федотович");
        employee6.setDepartment(depDesigners);
        employee6.setPosition("дизайнер");

        Employee employee7 = new Employee("Фролов", "Лаврентий", "Мэлсович");
        employee7.setDepartment(depAnalysts);
        employee7.setPosition("аналитик");

        Employee employee8 = new Employee("Харитонов", "Мэлор", "Максимович");
        employee8.setDepartment(depAnalysts);
        employee8.setPosition("аналитик");

        Employee employee9 = new Employee("Михайлов", "Руслан", "Макарович");
        employee9.setDepartment(depProgrammers);
        employee9.setPosition("программист");

        Employee employee10 = new Employee("Логинов", "Протасий", "Александрович");
        employee10.setDepartment(depManagement);
        employee10.setPosition("менеджер");

        Employee employee11 = new Employee("Поляков", "Герман", "Ярославович");
        employee11.setDepartment(depManagement);
        employee11.setPosition("менеджер");

        Employee employee12 = new Employee("Логинова", "Людмила", "Григорьевна");
        employee12.setDepartment(depDesigners);
        employee12.setPosition("дизайнер");

        Employee employee13 = new Employee("Фомин", "Антонин", "Дмитрьевич");
        employee13.setDepartment(depManagement);
        employee13.setPosition("менеджер");

        Employee employee14 = new Employee("Белов", "Демьян", "Никитевич");
        employee14.setDepartment(depProgrammers);
        employee14.setPosition("программист");

        Employee employee15 = new Employee("Филатов", "Владимир", "Богданович");
        employee15.setDepartment(depProgrammers);
        employee15.setPosition("программист");

        Employee employee16 = new Employee("Быкова", "Евгения", "Улебовна");
        employee16.setDepartment(depProgrammers);
        employee16.setPosition("программист");

        Employee employee17 = new Employee("Казакова", "София", "Мартыновна");
        employee17.setDepartment(depManagement);
        employee17.setPosition("менеджер");

        Employee employee18 = new Employee("Зайцева", "Анастасия", "Евгеньевна");
        employee18.setDepartment(depFinance);
        employee18.setPosition("финансист");

        Employee employee19 = new Employee("Пахомова", "Евдокия", "Геннадьевна");
        employee19.setDepartment(depFinance);
        employee19.setPosition("финансист");

        Employee employee20 = new Employee("Марков", "Ким", "Валентинович");
        employee20.setDepartment(depFinance);
        employee20.setPosition("финансист");

        // руководители
        Head head1 = new Head("Мельников", "Валентин", "Андреевич");
        head1.setDepartment(depProject);
        head1.setPosition("руководитель проектов");

        Head head2 = new Head("Фадеев", "Улеб", "Лукьянович");
        head2.setDepartment(depProject);
        head2.setPosition("руководитель проектов");

        Head head3 = new Head("Рябова", "Акулина", "Владиславовна");
        head3.setDepartment(depProject);
        head3.setPosition("руководитель проектов");

        Head head4 = new Head("Фомичёв", "Ким", "Улебович");
        head4.setDepartment(depProject);
        head4.setPosition("руководитель проектов");

        Head head5 = new Head("Белозёмов", "Илья", "Ефимович");
        head5.setDepartment(depProject);
        head5.setPosition("руководитель проектов");



        // заказчики
        Customer customer1 = new Customer("Ковалёва", "Надежда", "Варламовна");
        customer1.setNameCompany("ИП Ковалёва");
        customer1.setPhoneNumber("+79271234567");

        Customer customer2 = new Customer("Носова", "Кира", "Альвиановна");
        customer2.setNameCompany("ИП Носова");
        customer2.setPhoneNumber("+79271234567");

        Customer customer3 = new Customer("Кошелева", "Регина", "Матвеевна");
        customer3.setNameCompany("ИП Кошелева");
        customer3.setPhoneNumber("+79271234567");

        Customer customer4 = new Customer("Денисов", "Арсений", "Богданович");
        customer4.setNameCompany("ИП Денисов");
        customer4.setPhoneNumber("+79271234567");

        Customer customer5 = new Customer("Крылов", "Станислав", "Брониславович");
        customer5.setNameCompany("ИП Крылов");
        customer5.setPhoneNumber("+79271234567");

        Customer customer6 = new Customer("Степанов", "Гордей", "Денисович");
        customer6.setNameCompany("ИП Степанов");
        customer6.setPhoneNumber("+79271234567");

        Customer customer7 = new Customer("Самойлова", "Ирина", "Леонидовна");
        customer7.setNameCompany("ИП Самойлова");
        customer7.setPhoneNumber("+79271234567");

        Customer customer8 = new Customer("Федотов", "Федосей", "Глебович");
        customer8.setNameCompany("ИП Федотов");
        customer8.setPhoneNumber("+79271234567");

        Customer customer9 = new Customer("Пахомов", "Владимир", "Евгеньевич");
        customer9.setNameCompany("ИП Пахомов");
        customer9.setPhoneNumber("+79271234567");

        Customer customer10 = new Customer("Крюкова", "Наталья", "Авксентьевна");
        customer10.setNameCompany("ИП Крюкова");
        customer10.setPhoneNumber("+79271234567");



        Project project1 = new Project("проект 1", head1, customer1);
        project1.setDescription("проект номер 1");
        employee1.addCurrentProjects(project1);
        employee2.addCurrentProjects(project1);
        employee3.addCurrentProjects(project1);

        Project project2 = new Project("проект 2", head1, customer1);
        project2.setDescription("проект номер 2");
        employee1.addCurrentProjects(project2);
        employee2.addCurrentProjects(project2);
        employee4.addCurrentProjects(project2);
        employee5.addCurrentProjects(project2);

        Project project3 = new Project("проект 3", head2, customer1);
        employee10.addCurrentProjects(project3);
        employee18.addCurrentProjects(project3);
        employee14.addCurrentProjects(project3);
        employee5.addCurrentProjects(project3);

        Project project4 = new Project("проект 4", head2, customer2);
        project4.setDescription("проект номер 4");
        employee1.addCurrentProjects(project4);
        employee2.addCurrentProjects(project4);
        employee4.addCurrentProjects(project4);
        employee5.addCurrentProjects(project4);

        Project project5 = new Project("проект 5", head2, customer2);
        project5.setDescription("проект номер 5");
        employee5.addCurrentProjects(project5);
        employee6.addCurrentProjects(project5);
        employee7.addCurrentProjects(project5);
        employee8.addCurrentProjects(project5);

        Project project6 = new Project("проект 6", head2, customer3);
        project6.setDescription("проект номер 6");
        employee2.addCurrentProjects(project6);
        employee7.addCurrentProjects(project6);
        employee8.addCurrentProjects(project6);
        employee9.addCurrentProjects(project6);

        Project project7 = new Project("проект 7", head3, customer3);
        project7.setDescription("проект номер 7");
        employee7.addCurrentProjects(project7);
        employee8.addCurrentProjects(project7);
        employee9.addCurrentProjects(project7);
        employee10.addCurrentProjects(project7);

        Project project8 = new Project("проект 8", head3, customer3);
        project8.setDescription("проект номер 8");
        employee11.addCurrentProjects(project8);
        employee12.addCurrentProjects(project8);
        employee14.addCurrentProjects(project8);
        employee15.addCurrentProjects(project8);

        Project project9 = new Project("проект 9", head3, customer4);
        project9.setDescription("проект номер 9");
        employee11.addCurrentProjects(project9);
        employee12.addCurrentProjects(project9);
        employee13.addCurrentProjects(project9);
        employee15.addCurrentProjects(project9);

        Project project10 = new Project("проект 10", head3, customer5);
        project10.setDescription("проект номер 10");
        employee13.addCurrentProjects(project10);
        employee12.addCurrentProjects(project10);
        employee16.addCurrentProjects(project10);
        employee17.addCurrentProjects(project10);

        Project project11 = new Project("проект 11", head3, customer5);
        project11.setDescription("проект номер 11");
        employee1.addCurrentProjects(project11);
        employee2.addCurrentProjects(project11);
        employee4.addCurrentProjects(project11);
        employee5.addCurrentProjects(project11);

        Project project12 = new Project("проект 12", head5, customer5);
        project12.setDescription("проект номер 12");
        employee1.addCurrentProjects(project12);
        employee2.addCurrentProjects(project12);
        employee4.addCurrentProjects(project12);
        employee5.addCurrentProjects(project12);

        Project project13 = new Project("проект 13", head5, customer6);
        project13.setDescription("проект номер 13");
        employee1.addCurrentProjects(project13);
        employee2.addCurrentProjects(project13);
        employee4.addCurrentProjects(project13);
        employee5.addCurrentProjects(project13);

        Project project14 = new Project("проект 14", head5, customer7);
        project14.setDescription("проект номер 14");
        employee1.addCurrentProjects(project14);
        employee2.addCurrentProjects(project14);
        employee4.addCurrentProjects(project14);
        employee5.addCurrentProjects(project14);

        Project project15 = new Project("проект 15", head5, customer7);
        project15.setDescription("проект номер 15");
        employee1.addCurrentProjects(project15);
        employee2.addCurrentProjects(project15);
        employee4.addCurrentProjects(project15);
        employee5.addCurrentProjects(project15);

        Project project16 = new Project("проект 16", head5, customer7);
        project16.setDescription("проект номер 16");
        employee15.addCurrentProjects(project16);
        employee16.addCurrentProjects(project16);
        employee17.addCurrentProjects(project16);
        employee18.addCurrentProjects(project16);

        Project project17 = new Project("проект 17", head1, customer8);
        project17.setDescription("проект номер 17");
        employee5.addCurrentProjects(project17);
        employee6.addCurrentProjects(project17);
        employee7.addCurrentProjects(project17);
        employee8.addCurrentProjects(project17);

        Project project18 = new Project("проект 18", head1, customer10);
        project18.setDescription("проект номер 18");
        employee7.addCurrentProjects(project18);
        employee8.addCurrentProjects(project18);
        employee9.addCurrentProjects(project18);
        employee10.addCurrentProjects(project18);

        Project project19 = new Project("проект 19", head1, customer10);
        project19.setDescription("проект номер 19");
        employee19.addCurrentProjects(project2);

        //---------------------------------------------------------------------
        Menu menu = new Menu();

//        for (Employee employee : menu.listEmployees(project1)) {
//            System.out.println(employee);
//        }

//        for (Project project : menu.listProjectsEmployee(employee1)) {
//            System.out.println(project);
//        }

//        for (Employee employee : menu.listEmployeesNoProjects(depFinance)) {
//            System.out.println(employee);
//        }

//        for (Employee employee : menu.listEmployeesNoProjects()) {
//            System.out.println(employee);
//        }

//        for (Employee employee : menu.listEmployeeHead(head1)) {
//            System.out.println(employee);
//        }

//        for (Head head : menu.listHeadEmployee(employee1)) {
//            System.out.println(head);
//        }

//        for (Employee employee : menu.listEmployeesInProjectsEmployee(employee9)) {
//            System.out.println(employee);
//        }

//        for (Project project : menu.listProjectsCustomer(customer7)) {
//            System.out.println(project);
//        }

//        for (Employee employee : menu.listEmployeesForCustomer(customer7)) {
//            System.out.println(employee);
//        }
    }
}
