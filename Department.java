package uni;

import java.util.List;
//import uni.Employee;
//import uni.IDepartmentStatestics;
//import uni.Student_Counseling;

public class Department implements IDepartmentStatestics {
	//private means that these variables are only accessed in the class
	private String Department_ID;
	private String Department_Name;
	private String Department_DOE;
	private List<Department> departments;
	private Student_Counseling numOfStudents;
	private Employee numOfEmployees;
    private Loader load;
                  
	
	//This constructor is responsible of initialzing a new instance with all three variables
	Department(String Department_ID, String Department_Name, String Department_DOE)
	{//the this refers to the current instance of the data where it assigns the current parameter of the constructor with its private variable
		this.Department_DOE = Department_DOE;
		this.Department_ID = Department_ID;
		this.Department_Name = Department_Name;
        this.load = new Loader();
		this.departments = load.loadDepartmentsFromFile();
        this.numOfEmployees = new Employee();
        this.numOfStudents = new Student_Counseling();

	}

    public Department() {
        load = new Loader();
        departments = load.loadDepartmentsFromFile();
    }
                      
	//These arez getter methods that provide access to private variables from outside the class
	public String getDepartment_ID() {
		return Department_ID;
	}
	
	public String getDepartment_Name() {
		return Department_Name;
	}
	
	public String getDepartment_DOE() {
		return Department_DOE;
	}
	//We used the toString Method to provide a string representation to the department object
	@Override
	public String toString() {
	    return "Department [\n" +
	           "  ID = " + Department_ID + ",\n" +
	           "  Name = " + Department_Name + ",\n" +
	           "  DOE = " + Department_DOE + "\n" +
	           "]";
	}

    public Department getDepartmentByID(String departmentID) {
        for (Department dept : departments) {
            if (dept.getDepartment_ID().equals(departmentID)) {
                return dept;
            }
        }
        return null;
    }
	@Override
	public int numOfEmployees(String departemntID) {
		// TODO Auto-generated method stub
		return numOfEmployees.getEmployeesByDepartment(departemntID).size();
	}

	@Override
	public int numOfStudent(String departmentID) {
		// TODO Auto-generated method stub
		return numOfStudents.getStudentsByDepartment(departmentID).size();
	}
}
