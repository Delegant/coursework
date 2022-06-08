public class Hard {


        public static void main(String[] args) {
            EmployeeBook employees = new EmployeeBook();

            employees.addEmployee("Ivanov Ivan Ivanovich", 1, 200);
            employees.addEmployee("Sidorov Michail", 2, 300);
            employees.addEmployee("Agent Smith", 3, 1000);
            employees.addEmployee("Mr Andersen", 1, 1);
            employees.removeEmployee("Mr Andersen", 3);
            employees.addEmployee("Mr newAndersen", 1, 1);
            employees.changeEmployeeDepartment("Mr newAndersen", 2);
            employees.changeEmployeeSalary("Mr newAndersen", 5);

            int department = 1;
            System.out.println("Минимальная зарплата отдел " + department + ":\n" + employees.findEmployeeMinSalaryOfDepartment(department));
            System.out.println("Максимальная зарплата отдел " + department + ":\n" + employees.findEmployeeMaxSalaryOfDepartment(department));
            System.out.println("Затраты на зарплату отдел " + department + ":\n" + employees.costsSum(department));
            System.out.println("Средняя зарплата отдел " + department + ":\n" + employees.getAverageSalary(department));
            System.out.println("Зарплаты отдела " + department + " проиндексированы на: " + employees.indexingSalary(department, 10) + "%");
            employees.printEmployeesOfDepartment(department);
            float salary = 200f;
            System.out.println("Сотрудники с зарплатой меньше " + salary);
            employees.printEmployeeWithSalaryLess(salary);
            System.out.println("Сотрудники с зарплатой больше или равно " + salary);
            employees.printEmployeeWithSalaryMore(salary);
        }

    }

