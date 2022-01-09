public class Easy {

    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {
        employees[0] = new Employee("Ivanov Ivan Ivanovich",1,200 );
        employees[1] = new Employee("Sidorov Michail",2,300 );
        employees[2] = new Employee("Agent Smith",3,1000 );
        employees[3] = new Employee("Mr Andersen",1,1 );
        printEmployees();
        System.out.println("Затраты на зарплату: " + costsSum());
        System.out.println("Минимальная зарплата: " + findEmployeeMinSalary());
        System.out.println("Максимальная зарплата: " + findEmployeeMaxSalary());
        System.out.println("Средняя зарплата: " + getAverageSalary());
        printFullNameEmployees();
    }

    public static void printEmployees() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }

    public static float costsSum() {
        float costsSum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                costsSum += employee.getSalary();
            }
        }
        return costsSum;
    }

    public static Employee findEmployeeMinSalary() {
        float lesser = Float.MAX_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && lesser > employee.getSalary()) {
                lesser = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static Employee findEmployeeMaxSalary() {
        float largest = Float.MIN_VALUE;
        Employee result = null;
        for (Employee employee : employees) {
            if (employee != null && largest < employee.getSalary()) {
                largest = employee.getSalary();
                result = employee;
            }
        }
        return result;
    }

    public static float getAverageSalary() {
        return costsSum() / Employee.getIdCounter();
    }

    public static void printFullNameEmployees() {
        for (Employee employee:employees){
            if (employee!=null){
                System.out.println(employee.getFullName());
            }
        }
    }

}
