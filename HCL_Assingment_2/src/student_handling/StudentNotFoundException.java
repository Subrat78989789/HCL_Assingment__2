package student_handling;

public class StudentNotFoundException extends Exception {
	public StudentNotFoundException(String Rollno) 
	{
		super("Student Whose RollNo "+Rollno+" do not exist");
	}

}
