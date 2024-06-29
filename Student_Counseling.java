package uni;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student_Counseling extends Person {
    private String dateOfAdmission;
    private String departmentChoices;
    private String departmentAdmission;
    private List<Student_Counseling> studentCounseling;
    private Loader studentLoader;

    public Student_Counseling(String ID, String Date_Of_Join, String dateOfAdmission, String departmentChoices, String departmentAdmission) {
        super(ID, Date_Of_Join);
        this.dateOfAdmission = dateOfAdmission;
        this.departmentChoices = departmentChoices;
        this.departmentAdmission = departmentAdmission;
        this.studentLoader = new Loader();
        this.studentCounseling = studentLoader.loadStudentCounselingFromFile();
    }

    public Student_Counseling() {
    	  studentLoader = new Loader();
        this.studentCounseling = studentLoader.loadStudentCounselingFromFile();
    }
    public String getDateOfAddmission() {
        return dateOfAdmission;
    }

    public String getDepartmentChoices() {
        return departmentChoices;
    }

    public String getDepartmentAdmission() {
        return departmentAdmission;
    }

    @Override
    public String toString() {
        return "Student Counseling [\n" +
               "  DOA=" + dateOfAdmission + ",\n" +
               "  Department Choices=" + departmentChoices + ",\n" +
               "  Department Admission=" + departmentAdmission + ",\n" +
               "  " + super.toString() + "\n" +
               "]";
    }
    public Student_Counseling getStudentCounselingByID(String studentCID) {
        for (Student_Counseling sc : studentCounseling) {
            if (sc.getID().equals(studentCID)) {
                return sc;
            }
        }
        return null;
    }
    public List<Student_Counseling> getStudentsByDepartment(String departmentID) {
        List<Student_Counseling> departmentStudents = new ArrayList<>();
        for (Student_Counseling sc : studentCounseling) {
            if (sc.getDepartmentAdmission().equals(departmentID)) {
                departmentStudents.add(sc);
            }
        }
        return departmentStudents;
    }
    public List<Student_Counseling> getStudentsByCriteria(String department, String dobStart, String dobEnd, String doaStart, String doaEnd) {
        List<Student_Counseling> filteredStudents = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        try {
            Date dobStartDate = sdf.parse(dobStart);
            Date dobEndDate = sdf.parse(dobEnd);
            Date doaStartDate = sdf.parse(doaStart);
            Date doaEndDate = sdf.parse(doaEnd);
            for (Student_Counseling sc : studentCounseling) {
                Date dob = sdf.parse(sc.getDateOfBirth());
                Date doa = sdf.parse(sc.getDateOfAddmission());
                if (sc.getDepartmentAdmission().equalsIgnoreCase(department) &&
                        dob.compareTo(dobStartDate) >= 0 && dob.compareTo(dobEndDate) <= 0 &&
                        doa.compareTo(doaStartDate) >= 0 && doa.compareTo(doaEndDate) <= 0) {
                    filteredStudents.add(sc);
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return filteredStudents;
    }
}
