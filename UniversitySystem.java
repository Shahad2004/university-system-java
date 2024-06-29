package uni;

import java.util.Scanner;
import java.util.List;

public class UniversitySystem {
    private Department department;
    private Employee employee;
    private Student_Counseling student_counseling;
    private Student_Performance student_performance;
    private Scanner scanner;
    private Loader load;

    public UniversitySystem() {
        scanner = new Scanner(System.in);
        this.load = new Loader();
        department = new Department();
        employee = new Employee();
        student_counseling = new Student_Counseling();
        student_performance = new Student_Performance();

    }

    public void start() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            boolean shouldExit = handleChoice(choice);
            if (shouldExit || !askToContinue()) {
                break;
            }
        }
        scanner.close();
    }

    private boolean handleChoice(int choice) {
        switch (choice) {
            case 1:
                retrieveInformationById();
                break;
            case 2:
                retrieveStudentsByCriteria();
                break;
            case 3:
                performStudentPerformanceStats();
                break;
            case 4:
                performDepartmentStatistics();
                break;
            case 5:
                retrieveEmployeesAndStudentsByDepartment();
                break;
            case 6:
                System.out.println("Exiting the system. Goodbye!");
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return false;
    }

    private void retrieveInformationById() {
        System.out.println("Choose the type of information to retrieve:");
        System.out.println("a. Department");
        System.out.println("b. Employee");
        System.out.println("c. Student Counseling");
        System.out.println("d. Student Performance");

        char subChoice = scanner.nextLine().charAt(0);
        switch (subChoice) {
            case 'a':
                System.out.println("Enter the Department ID:");
                String deptID = scanner.nextLine();
                Department department1 = department.getDepartmentByID(deptID);
                if (department != null) {
                    System.out.println(department1);
                } else {
                    System.out.println("Department not found.");
                }
                break;
            case 'b':
                System.out.println("Enter the Employee ID:");
                String empID = scanner.nextLine();
                Employee employee1 = employee.getEmployeeByID(empID);
                if (employee != null) {
                    System.out.println(employee1);
                } else {
                    System.out.println("Employee not found.");
                }
                break;
            case 'c':
                System.out.println("Enter the Student ID:");
                String scID = scanner.nextLine();
                Student_Counseling studentCounseling = student_counseling.getStudentCounselingByID(scID);
                if (studentCounseling != null) {
                    System.out.println(studentCounseling);
                } else {
                    System.out.println("Student Counseling record not found.");
                }
                break;
            case 'd':
                System.out.println("Enter the Student ID:");
                String spID = scanner.nextLine();
                Student_Performance studentPerformance = student_performance.getStudentPerformanceByID(spID);
                if (studentPerformance != null) {
                    System.out.println(studentPerformance);
                } else {
                    System.out.println("Student Performance record not found.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void retrieveStudentsByCriteria() {
        System.out.print("Enter Department ID: ");
        String department = scanner.nextLine();
        System.out.print("Enter DOB Start (yyyy-MM-dd): ");
        String dobStart = scanner.nextLine();
        System.out.print("Enter DOB End (yyyy-MM-dd): ");
        String dobEnd = scanner.nextLine();
        System.out.print("Enter DOA Start (yyyy-MM-dd): ");
        String doaStart = scanner.nextLine();
        System.out.print("Enter DOA End (yyyy-MM-dd): ");
        String doaEnd = scanner.nextLine();
        List<Student_Counseling> students = student_counseling.getStudentsByCriteria(department, dobStart, dobEnd, doaStart, doaEnd);
        students.forEach(System.out::println);
    }

    private void performStudentPerformanceStats() {
        System.out.print("Enter Student ID: ");
        String studentID = scanner.nextLine();
        student_performance.calculateMaxMarks(studentID);
        student_performance.calculateMinMarks(studentID);
        student_performance.calculateNumOfPapers(studentID);
        student_performance.calculateTotalMarks(studentID);
    }

    private void performDepartmentStatistics() {
        System.out.print("Enter Department ID: ");
        String departmentID = scanner.nextLine();
        int numEmployee = department.numOfEmployees(departmentID);
        int numStudent = department.numOfStudent(departmentID);
        System.out.println("Num of Employees:" + numEmployee);
        System.out.println("Num of Employees:" + numStudent);
    }

    private void retrieveEmployeesAndStudentsByDepartment() {
        System.out.print("Enter Department ID: ");
        String deptID = scanner.nextLine();
        List<Employee> employees = employee.getEmployeesByDepartment(deptID);
        List<Student_Counseling> studentDetails = student_counseling.getStudentsByDepartment(deptID);
        System.out.println("Employees in Department " + deptID + ":");
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee emp : employees) {
                System.out.println(emp);
            }
        }

        System.out.println("\nStudents in Department " + deptID + ":");
        if (studentDetails.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student_Counseling student : studentDetails) {
                System.out.println(student);
            }
        }
    }

    private boolean askToContinue() {
        System.out.println("Do you want to perform another operation? (yes/no)");
        String continueChoice = scanner.nextLine().trim().toLowerCase();
        return continueChoice.equals("yes");
    }

    private void displayMenu() {
        System.out.println("Welcome to our University system!! Choose one of the following options:");
        System.out.println("1. Retrieve the information of specific department, Employee, Student Counseling, and Student Performance based on a given ID.");
        System.out.println("2. Retrieve all students’ information for students in a given department, date of birth within a range and Dates of Admission within a range of Dates.");
        System.out.println("3. Perform statistical operations on student performance info.");
        System.out.println("4. Perform statistical operations on departments.");
        System.out.println("5. Retrieve student and employee info that belong to a specific department.");
        System.out.println("6. Exit");
    }

    public static void main(String[] args) {
       
        UniversitySystem universitySystem = new UniversitySystem();
        universitySystem.start();
    }
}
