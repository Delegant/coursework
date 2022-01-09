public class Employee {
    private final String fullName;
    private int department;
    private float salary;
    private static int idCounter;
    private final int id;

    public Employee(String fullName, int department, float salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = idCounter++;
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

    public static int getIdCounter() {
        return idCounter;
    }

    @Override
    public String toString() {
        return "Full Name: " + fullName +
                ", Salary: " + salary +
                ", Department: " + department +
                ", ID: " + id;
    }

}
