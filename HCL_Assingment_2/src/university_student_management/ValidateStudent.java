package university_student_management;

import java.util.regex.Pattern;

public class ValidateStudent {
	public boolean Student_Id_Validation(String id)
	{
		if(Pattern.matches("^stu\\d{3,}$", id))
		{
			return true;
		}
		return false;
	}

}
