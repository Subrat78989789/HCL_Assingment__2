package university_student_management;

import java.util.Map;

public interface StudentServices {

	public void addStudents(Student s);
	public void displayStudents();
	public Student searchById(String id);
	public void removeById(String id);
	public void sortByMarks();
	
	
}
