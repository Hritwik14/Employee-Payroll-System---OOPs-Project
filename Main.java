import java.util.*;

abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public abstract double calculateSalary();

    @Override
    public String toString() {
        return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
    }

}

class FullTimeEmployee extends Employee {

    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override

    public double calculateSalary() {
        return monthlySalary;
    }

}

class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
        super(name, id);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

}

class PayrollSystem {
    private ArrayList<Employee> employeeList;

    public PayrollSystem() {
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }

    public void removeEmployee(int id) {
        Employee employeeToRemove = null;
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeToRemove = employee;
                break;
            }
        }
        if (employeeToRemove != null) {
            employeeList.remove(employeeToRemove);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void displayEmployees() {
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

}

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();

        /*
         * FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000);
         * PartTimeEmployee emp2 = new PartTimeEmployee("Ramesh", 2, 40, 100);
         * 
         * payrollSystem.addEmployee(emp1);
         * payrollSystem.addEmployee(emp2);
         * System.out.println("Initial Employee List: ");
         * payrollSystem.displayEmployees();
         * System.out.println("Removing Employees");
         * payrollSystem.removeEmployee(2);
         * System.out.println("Remaining Employees Details: ");
         * payrollSystem.displayEmployees();
         */

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Welcome to Employee Payroll System!!");
            System.out.println("Press 1 to add Full Time Employee");
            System.out.println("Press 2 to add Part Time Employee");
            System.out.println("Press 3 to remove Employee");
            System.out.println("Press 4 to check Employee Details");
            System.out.println("Press 5 to EXIT");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Enter employee name,id and monthly salary:");
                    String n1 = sc.next();
                    int id1 = sc.nextInt();
                    double sal = sc.nextDouble();
                    FullTimeEmployee emp1 = new FullTimeEmployee(n1, id1, sal);
                    payrollSystem.addEmployee(emp1);
                    break;

                case 2:
                    System.out.println("Enter employee name,id, hours worked and hourly rate:");
                    String n2 = sc.next();
                    int id2 = sc.nextInt();
                    int hr = sc.nextInt();
                    double r = sc.nextDouble();
                    PartTimeEmployee emp2 = new PartTimeEmployee(n2, id2, hr, r);
                    payrollSystem.addEmployee(emp2);
                    break;

                case 3:
                    System.out.println("Enter the id of employee to be removed:");
                    int id3 = sc.nextInt();
                    payrollSystem.removeEmployee(id3);
                    System.out.println("Employee removed successfully!!");
                    break;

                case 4:
                    payrollSystem.displayEmployees();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Enter a valid choice!!");

            }
        }

    }
}
