package uni;
import java.util.List;


public class Student_Performance implements IStudentPerformanceStats{

	//C:\Users\ASUS\OneDrive - AL-Hussien bin Abdullah Technical University\Desktop\2 Year\semester 2\Discrete Math
	private String Student_ID;
	private String Semester_Name;
	private String Paper_ID;
	private String Paper_Name;
	private int Marks;
                      private List<Student_Performance> studentPerformances;
                      private Loader load;
                      
    
    
	Student_Performance(String Student_ID,String Semester_Name,String Paper_ID,String Paper_Name,int Marks)
{
		this.Student_ID= Student_ID;
		this.Semester_Name=Semester_Name;
		this.Paper_ID=Paper_ID;
		this.Marks= Marks;
		this.Paper_Name =Paper_Name;
                                           this.load= new Loader();
                                           this.studentPerformances = load.loadStudentPerformanceFromFile();
}
	Student_Performance(){
	load = new Loader();
            this.studentPerformances = load.loadStudentPerformanceFromFile();
	}
	public String getStudentID() {
		return Student_ID;
	}
	
	public String getSemesterName() {
		return Semester_Name;
	}
	
	public String getPaperID() {
		return  Paper_ID;
	}
	
	public String getPaperName() {
		return Paper_Name;
	}
	
	public int getMarks() {
		return Marks;
	}
	@Override
	public String toString() {
	    return "Student [\n" +
	           "  ID = " + Student_ID + ",\n" +
	           "  Semester Name = " + Semester_Name + ",\n" +
	           "  Paper ID = " + Paper_ID + ",\n" +
	           "  Paper Name = " + Paper_Name + ",\n" +
	           "  Marks = " + Marks + "\n" +
	           "]";
	}
	 public Student_Performance getStudentPerformanceByID(String studentPID) {
	        for (Student_Performance sp : studentPerformances) {
	            if (sp.getStudentID().equals(studentPID)) {
	                return sp;
	            }
	        }
	        return null;
	    }
	 public int calculateMinMarks(String studentPID) {
		    int minMarks = Integer.MAX_VALUE;

		    for (Student_Performance sp : studentPerformances) {
		        if (sp.getStudentID().equals(studentPID)) {
		            int marks = sp.getMarks();
		            if (marks < minMarks) {
		                minMarks = marks;
		            }
		        }
		    }

		    return minMarks;
		}
		
		public int calculateMaxMarks(String studentPID) {
		    int maxMarks = Integer.MIN_VALUE;

		    for (Student_Performance sp : studentPerformances) {
		        if (sp.getStudentID().equals(studentPID)) {
		            int marks = sp.getMarks();
		            if (marks > maxMarks) {
		                maxMarks = marks;
		            }
		        }
		    }

		    return maxMarks;
		}
	  public int calculateNumOfPapers(String studentPID) {
	    int numOfPapers = 0;

	    for (Student_Performance sp : studentPerformances) {
	        if (sp.getStudentID().equals(studentPID)) {
	            numOfPapers++;
	        }
	    }

	    return numOfPapers;
	}
	public int calculateTotalMarks(String studentPID) {
	    int totalMarks = 0;

	    for (Student_Performance sp : studentPerformances) {
	        if (sp.getStudentID().equals(studentPID)) {
	            totalMarks += sp.getMarks();
	        }
	    }

	    return totalMarks;
	}
}
