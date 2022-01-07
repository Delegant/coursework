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
        return listEmployees(employees,0);
    }

    public static CharSequence listEmployees(Employee[] employees, int department) {
        StringBuilder listEmployeesBuilder = new StringBuilder();
        boolean needDepartment = true;
        if (department !=0) {
            employees = filterByDepartment(employees, department);
            needDepartment = false;
        }
        for (Employee employee : employees) {
            if (employee != null) {
                listEmployeesBuilder.append("\n").append(employee.toString(true,true,needDepartment,true));
            }
        }
        return listEmployeesBuilder;
    }

    public static float costsSum(Employee[] employees) {
        float costsSum = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                costsSum += employee.getSalary();
            }
        }
        return costsSum;
    }

    public static float costsSum(Employee[] employees, int department) {
        employees = filterByDepartment(employees, department);
        return costsSum(employees);
    }

    public static Employee findEmployeeMinSalary(Employee[] employees) {
        Employee largest = employees[0];
        for (Employee employee : employees) {
            if (employee != null) {
                if (largest.getSalary() > employee.getSalary()) largest = employee;
            }
        }
        return largest;
    }

    public static Employee findEmployeeMinSalary(Employee[] employees, int department) {
        return findEmployeeMinSalary(filterByDepartment(employees, department));
    }

    public static Employee findEmployeeMaxSalary(Employee[] employees) {
        Employee largest = employees[0];
        for (Employee employee : employees) {
            if (employee != null) {
                if (largest.getSalary() < employee.getSalary()) largest = employee;
            }
        }
        return largest;
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
        for (Employee employee : employees) {
            if (employee != null) {
                allFullNameBuilder.append("\n").append(employee.toString(true,false,false,false));
            }
        }
        return allFullNameBuilder;
    }

    public static CharSequence listFullNameEmployees(Employee[] employees, int department) {
        return listFullNameEmployees(filterByDepartment(employees, department));
    }

    public static int indexingSalary(Employee[] employees, int percent) {
        for (Employee employee : employees) {
            if (employee != null) {
                employee.setSalary(employee.getSalary() + employee.getSalary() / 100 * percent);
            }
        }
        return percent;
    }

    public static CharSequence employeeWithSalaryMore(Employee[] employees, int salary){
        StringBuilder salaryMoreBuilder = new StringBuilder();
        salaryMoreBuilder.append(salary).append(":\n");
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() >= salary) {
                    salaryMoreBuilder.append("\n").append(employee.toString(true,true,true,true));
                }
            }
        }
        return salaryMoreBuilder;
    }

    public static CharSequence employeeWithSalaryLess(Employee[] employees, int salary){
        StringBuilder salaryLessBuilder = new StringBuilder();
        salaryLessBuilder.append(salary).append(":\n");
        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.getSalary() < salary) {
                    salaryLessBuilder.append('\n').append(employee.toString(true,true,true,true));
                }
            }
        }
        return salaryLessBuilder;
    }

    public static int indexingSalary(Employee[] employees, int percent, int department) {
        return indexingSalary(filterByDepartment(employees, department), percent);
    }

    public static Employee[] filterByDepartment(Employee[] employees, int department) {
        Employee[] departmentEmployees = employees.clone();
        for (int i = 0; i<employees.length; ++i) {
            if (employees[i] != null) {
                if (employees[i].getDepartment() != department) departmentEmployees[i] = null;
            }
        }
        return departmentEmployees;
    }

    @Override
    public String toString() {
        return this.toString(true,true,true,true);
    }

    public String toString(boolean needFullName, boolean needSalary, boolean needDepartment, boolean needID) {
        StringBuilder resultString = new StringBuilder();
        if (needFullName)  resultString.append("Full Name: ").append(fullName).append(" ");
        if (needSalary) resultString.append("Salary: ").append(salary).append(" ");
        if (needDepartment) resultString.append("Department: ").append(department).append(" ");
        if (needID) resultString.append("ID: ").append(id).append(" ");
        return resultString.toString();
    }

}
