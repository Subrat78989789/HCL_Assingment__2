package student_handling;



public interface StudentOperations {
public  void addStudents(Student s);
public void displayStudents();
public void removeByRoll() throws StudentNotFoundException;
public void searchByRoll() throws StudentNotFoundException; 
	

}
