public class Medium {

    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Ivanov Ivan Ivanovich", 1, 200);
        employees[1] = new Employee("Sidorov Michail", 2, 300);
        employees[2] = new Employee("Agent Smith", 3, 1000);
        employees[3] = new Employee("Mr Andersen", 1, 1);
        int department = 1;
        System.out.println("Минимальная зарплата отел " + department + ":\n" + findEmployeeMinSalaryOfDepartment(department));
        System.out.println("Максимальная зарплата отел " + department + ":\n" + findEmployeeMaxSalaryOfDepartment(department));
        System.out.println("Затраты на зарплату отел " + department + ":\n" + costsSum(department));
        System.out.println("Средняя зарплата отел " + department + ":\n" + meanSalary(department));
        System.out.println("Зарплаты отдела " + department + " проиндексированы на: " + indexingSalary(department, 10) + "%");
        printEmployeesOfDepartment(department);
        float salary = 200f;
        System.out.println("Сотрудники с зарплатой меньше " + salary);
        printEmployeeWithSalaryLess(salary);
        System.out.println("Сотрудники с зарплатой больше или равно " + salary);
        printEmployeeWithSalaryMore(salary);
    }

    public static Employee findEmployeeMinSalaryOfDepartment(int department) {
        ;
        float lesser = Float.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && lesser > employee.getSalary() && employee.getDepartment() == department) {
                lesser = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee findEmployeeMaxSalaryOfDepartment(int department) {
        float largest = Float.MIN_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && largest < employee.getSalary() && employee.getDepartment() == department) {
                largest = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static float costsSum(int department) {
        float costsSum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                costsSum += employee.getSalary();
            }
        }
        return costsSum;
    }

    public static float meanSalary(int department) {
        float costsSum = 0;
        int size = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                costsSum += employee.getSalary();
                size++;
            }
        }
        return costsSum / size;
    }

    public static int indexingSalary(int department, int percent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
        return percent;
    }

    public static void printEmployeesOfDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Full name: " + employee.getFullName() + " Salary: " + employee.getSalary() + " ID: " + employee.getId());
            }
        }
    }

    public static void printEmployeeWithSalaryMore(float salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println(employee);
            }
        }
    }

    public static void printEmployeeWithSalaryLess(float salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println(employee);
            }
        }
    }

}
