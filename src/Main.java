public class Main {

    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Ivanov Ivan Ivanovich",1,200 );
        employees[1] = new Employee("Sidorov Michail",2,300 );
        employees[2] = new Employee("Agent Smith",3,1000 );
        employees[3] = new Employee("Mr Andersen",1,1 );
        System.out.println("Список сотрудников: " + Employee.listEmployees(employees));
        System.out.println("Затраты на зарплату: " + Employee.costsSum(employees));
        System.out.println("Минимальная зарплата: " + Employee.findEmployeeMinSalary(employees));
        System.out.println("Максимальная зарплата: " + Employee.findEmployeeMaxSalary(employees));
        System.out.println("Средняя зарплата: " + Employee.meanSalary(employees));
        System.out.println("Список имен сотрудников: " + Employee.listFullNameEmployees(employees));
        Employee.indexingSalary(employees, 10);
        System.out.println("Список сотрудников: " + Employee.listEmployees(employees));
        System.out.println("Список сотрудников отел 1: " + Employee.listEmployees(employees,1));
        System.out.println("Затраты на зарплату отел 1: " + Employee.costsSum(employees, 1));
        System.out.println("Минимальная зарплата отел 1: " + Employee.findEmployeeMinSalary(employees, 1));
        System.out.println("Максимальная зарплата отел 1: " + Employee.findEmployeeMaxSalary(employees, 1));
        System.out.println("Средняя зарплата отел 1: " + Employee.meanSalary(employees, 1));
        System.out.println("Список имен сотрудников отел 1: " + Employee.listFullNameEmployees(employees, 1));
        System.out.println("Зарплата проиндексирована на: " + Employee.indexingSalary(employees, 10, 1) + "%");
        System.out.println("Список сотрудников отел 1: " + Employee.listEmployees(employees,1));
        System.out.println("Список сотрудников c зарплатой меньше " + Employee.employeeWithSalaryLess(employees, 200));
        System.out.println("Список сотрудников c зарплатой больше или равно " + Employee.employeeWithSalaryMore(employees, 200));


    }


}
