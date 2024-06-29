package uni;

import java.util.ArrayList;
import java.util.List;

public class Employee extends Person {
    private String Date_Of_Join;
    private Department department;
    private List<Employee> employees;
    private Loader load;

    // Constructor with parameters
    public Employee(String ID, String Date_Of_Birth, String Date_Of_Join, Department department) {
        super(ID, Date_Of_Birth);
        this.Date_Of_Join = Date_Of_Join;
        this.department = department;
        this.load = new Loader();
        this.employees = load.loadEmployeesFromFile();
    }

    public Employee() {
                       load = new Loader();
    	 this.employees = load.loadEmployeesFromFile();
    }

    public String getEmployee_DOJ() {
        return Date_Of_Join;
    }

    public Department getEmployee_Department() {
        return department;
    }

    @Override
    public String toString() {
        return "Employee [\n" +
               "  " + super.toString() + ",\n" +
               "  DOJ = " + Date_Of_Join + ",\n" +
               "  Department = " + department + "\n" +
               "]";
    }

    public Employee getEmployeeByID(String employeeID) {
        for (Employee emp : employees) {
            if (emp.getID().equals(employeeID)) {
                return emp;
            }
        }
        return null;
    }

    public List<Employee> getEmployeesByDepartment(String departmentID) {
        List<Employee> departmentEmployees = new ArrayList<>();
        for (Employee emp : employees) {
            if (emp.getEmployee_Department().getDepartment_ID().equals(departmentID)) {
                departmentEmployees.add(emp);
            }
        }
        return departmentEmployees;
    }
}