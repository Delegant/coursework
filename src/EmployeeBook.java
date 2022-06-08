import java.util.Objects;

public class EmployeeBook {

    private final Employee[] employees = new Employee[10];

    public void addEmployee(String fullName, int department, float salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = new Employee(fullName, department, salary);
                break;
            }
        }
    }

    public void removeEmployee(String fullName, int ID) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == ID && Objects.equals(employees[i].getFullName(), fullName)) {
                Employee.setIdCounter(Employee.getIdCounter()-1);
                employees[i] = null;
                break;
            }
        }
    }

    public void removeEmployee(int ID) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == ID) {
                Employee.setIdCounter(Employee.getIdCounter()-1);
                employees[i] = null;
                break;
            }
        }
    }

    public void changeEmployeeDepartment(String fullName, int department){
        for (Employee employee : employees) {
            if (employee != null && Objects.equals(employee.getFullName(), fullName)) {
                employee.setDepartment(department);
                break;
            }
        }
    }

    public void changeEmployeeSalary(String fullName, float salary){
        for (Employee employee : employees) {
            if (employee != null && Objects.equals(employee.getFullName(), fullName)) {
                employee.setSalary(salary);
                break;
            }
        }
    }

    public Employee findEmployeeMinSalaryOfDepartment(int department) {
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

    public Employee findEmployeeMaxSalaryOfDepartment(int department) {
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

    public float costsSum(int department) {
        float costsSum = 0;
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                costsSum += employee.getSalary();
            }
        }
        return costsSum;
    }

    public float getAverageSalary(int department) {
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

    public int indexingSalary(int department, int percent) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                float currentSalary = employee.getSalary();
                employee.setSalary(currentSalary * (percent / 100f + 1));
            }
        }
        return percent;
    }

    public void printEmployeesOfDepartment(int department) {
        for (Employee employee : employees) {
            if (employee != null && employee.getDepartment() == department) {
                System.out.println("Full name: " + employee.getFullName() + " Salary: " + employee.getSalary() + " ID: " + employee.getId());
            }
        }
    }

    public void printEmployeeWithSalaryMore(float salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println(employee);
            }
        }
    }

    public void printEmployeeWithSalaryLess(float salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println(employee);
            }
        }
    }

}
