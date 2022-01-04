public class Main {

    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Ivanov Ivan Ivanovich",1,200 );
        employees[1] = new Employee("Sidorov Michail",2,300 );
        employees[2] = new Employee("Agent Smith",3,1000 );
        employees[3] = new Employee("Mr Andersen",1,1 );
        System.out.println("Список сотрудников: " + '\n' + Employee.listEmployees(employees));
        System.out.println("Затраты на зарплату: " + '\n' + Employee.costsSum(employees));
        System.out.println("Минимальная зарплата: " + '\n' + Employee.findEmployeeMinSalary(employees));
        System.out.println("Максимальная зарплата: " + '\n' + Employee.findEmployeeMaxSalary(employees));
        System.out.println("Средняя зарплата: " + '\n' + Employee.meanSalary(employees));
        System.out.println("Список имен сотрудников: " + '\n' + Employee.listFullNameEmployees(employees));
        Employee.indexingSalary(employees, 10);
        System.out.println("Список сотрудников: " + '\n' + Employee.listEmployees(employees));

        System.out.println("Список сотрудников отел 1: " + '\n' + Employee.listEmployees(employees,1));
        System.out.println("Затраты на зарплату отел 1: " + '\n' + Employee.costsSum(employees, 1));
        System.out.println("Минимальная зарплата отел 1: " + '\n' + Employee.findEmployeeMinSalary(employees, 1));
        System.out.println("Максимальная зарплата отел 1: " + '\n' + Employee.findEmployeeMaxSalary(employees, 1));
        System.out.println("Средняя зарплата отел 1: " + '\n' + Employee.meanSalary(employees, 1));
        System.out.println("Список имен сотрудников отел 1: " + '\n' + Employee.listFullNameEmployees(employees, 1));
        Employee.indexingSalary(employees, 10, 1);
        System.out.println("Список сотрудников отел 1: " + '\n' + Employee.listEmployees(employees,1));

    }


}
