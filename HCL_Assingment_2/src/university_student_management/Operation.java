package university_student_management;

import java.time.LocalDateTime;

public class Operation {

	    String action;
	    Student student=null;
	    LocalDateTime time;

	    public Operation(String action, Student student) {
	        this.action = action;
	        this.student = student;
	        this.time = LocalDateTime.now();
	    }
	    public Operation(String action) {
	        this.action = action;
	        this.time = LocalDateTime.now();
	    }

	    @Override
	    public String toString() {
	    	if(student==null)
	    	{
	    		return action +" | " + time;
	    	}
	        return action + " | " + student.getId() + " | " + time;
	    }
	}



