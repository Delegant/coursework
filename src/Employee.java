import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Employee {
    private final String fullName;
    private int department;
    private float salary;
    private static int size;
    private final int id;

    public Employee(String fullName, int department, float salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = size++;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public float getSalary() {
        return salary;
    }

    public static int getSize() {
        return size;
    }

    public static CharSequence listEmployees(Employee[] employees) {
        StringBuilder listEmployeesBuilder = new StringBuilder();
        Function<Employee, StringBuilder> employeeFunction = (e) -> listEmployeesBuilder.append(e).append("\n");
        return employeeIterating(employeeFunction, employees);
    }

    public static CharSequence listEmployees(Employee[] employees, int department) {
        StringBuilder listEmployeesBuilder = new StringBuilder();
        employees = filterByDepartment(employees, department);
        Function<Employee, StringBuilder> employeeFunction = (e) -> listEmployeesBuilder
                .append("Full Name: ").append(e.getFullName())
                .append(", Salary: ").append(e.getSalary())
                .append(", ID: ").append(e.getId()).append("\n");
        return employeeIterating(employeeFunction, employees);
    }

    public static float costsSum(Employee[] employees) {
        float[] costsSum = {0};
        return employeeIterating((e) -> (costsSum[0] += e.getSalary()), employees);
    }

    public static float costsSum(Employee[] employees, int department) {
        employees = filterByDepartment(employees, department);
        return costsSum(employees);
    }

    public static Employee findEmployeeMinSalary(Employee[] employees) {
        Employee[] largest = {employees[0]};
        return employeeIterating((e) -> (largest[0].getSalary() > e.getSalary() ? largest[0] = e : largest[0]), employees);
    }

    public static Employee findEmployeeMinSalary(Employee[] employees, int department) {
        return findEmployeeMinSalary(filterByDepartment(employees, department));
    }

    public static Employee findEmployeeMaxSalary(Employee[] employees) {
        Employee[] largest = {employees[0]};
        return employeeIterating((e) -> (largest[0].getSalary() < e.getSalary() ? largest[0] = e : largest[0]), employees);
    }

    public static Employee findEmployeeMaxSalary(Employee[] employees, int department) {
        return findEmployeeMaxSalary(filterByDepartment(employees, department));
    }

    public static float meanSalary(Employee[] employees) {
        return costsSum(employees) / size;
    }

    public static float meanSalary(Employee[] employees, int department) {
        Employee[] filteredEmployees = filterByDepartment(employees, department);
        return costsSum(filteredEmployees) / filteredEmployees.length;
    }

    public static CharSequence listFullNameEmployees(Employee[] employees) {
        StringBuilder allFullNameBuilder = new StringBuilder();
        Function<Employee, StringBuilder> employeeFunction = (e) -> allFullNameBuilder.append(e.getFullName()).append("\n");
        return employeeIterating(employeeFunction, employees);
    }

    public static CharSequence listFullNameEmployees(Employee[] employees, int department) {
        return listFullNameEmployees(filterByDepartment(employees, department));
    }

    public static void indexingSalary(Employee[] employees, int percent) {
        Consumer<Employee> employeeConsumer = (e) -> e.setSalary(e.getSalary() + e.getSalary()/100 * percent);
        employeeIterating(employeeConsumer, employees);
    }

    public static void indexingSalary(Employee[] employees, int percent, int department) {
        indexingSalary(filterByDepartment(employees, department), percent);
    }

    public static Employee[] filterByDepartment(Employee[] employees, int department) {
        List<Employee> listEmployee = new ArrayList();
        Consumer<Employee> employeeConsumer = (e) -> {
            if (e.getDepartment() == department) listEmployee.add(e);
        };
        employeeIterating(employeeConsumer, employees);
        return listEmployee.toArray(new Employee[listEmployee.size()]);
    }

    public static <T> T employeeIterating(Function<Employee, T> employeesTransformer, Employee[] employees) {
        T result = null;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                result = employeesTransformer.apply(employees[i]);
            }
        }
        return result;
    }

    public static void employeeIterating(Consumer<Employee> employeesTransformer, Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                employeesTransformer.accept(employees[i]);
            }
        }
    }

    @Override
    public String toString() {
        return "Full Name: " + fullName +
                ", Salary: " + salary +
                ", Department: " + department +
                ", ID: " + id;
    }

}
