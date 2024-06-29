package uni;

public interface IStudentPerformanceStats {

	int calculateMinMarks(String studentPID);
	int calculateMaxMarks(String studentPID);
	int calculateNumOfPapers(String studentPID);
	int calculateTotalMarks(String studentPID);
}
