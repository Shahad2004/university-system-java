package uni;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//import uni.Student_Counseling;


public class Loader {
    private List<Employee> employees;
    private List<Department> departments;
    private List<Student_Performance> studentPerformances;
    private List<Student_Counseling> studentCounseling;

    public Loader() {
        employees = new ArrayList<>();
        departments = new ArrayList<>();
        studentPerformances = new ArrayList<>();
        studentCounseling = new ArrayList<>();
    }

    public List<Employee>loadEmployeesFromFile() {
        String filePath = "Employee_Information.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    Department dept = getDepartmentByID(parts[3]);
                    if (dept != null) {
                        Employee emp = new Employee(parts[0], parts[1], parts[2], dept);
                        employees.add(emp);
                    } else {
                        System.out.println("Invalid department ID: " + parts[3]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
   return  employees;
    }

    public List<Department> loadDepartmentsFromFile() {
        String filePath = "C:\\Users\\kenny\\Desktop\\Department_Information - Copy.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    Department dept = new Department(parts[0], parts[1], parts[2]);
                    departments.add(dept);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     return  departments;
    }

    public List<Student_Performance> loadStudentPerformanceFromFile() {
        String filePath = "Student_Performance_Data.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip the header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    try {
                        int marks = Integer.parseInt(parts[4]);
                        Student_Performance sp = new Student_Performance(parts[0], parts[1], parts[2], parts[3], marks);
                        studentPerformances.add(sp);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number format for marks: " + parts[4]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     return  studentPerformances;
    }

    public List<Student_Counseling> loadStudentCounselingFromFile() {
        String filePath = "Student_Counceling_Information.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Skip the header line
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    Student_Counseling sc = new Student_Counseling(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    studentCounseling.add(sc);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     return studentCounseling;
    }
    
    private Department getDepartmentByID(String departmentID) {
        for (Department dept : departments) {
            if (dept.getDepartment_ID().equals(departmentID)) {
                return dept;
            }
        }
        return null;
    }
}
