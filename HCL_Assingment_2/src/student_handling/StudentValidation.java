package student_handling;

public class StudentValidation {
	public static boolean validateRollNo(String Roll)
	{
		if(Roll.matches("^STU[0-9]{3}$"))
		{
			
			return true;
		}
		
		return false;
	}
	public static boolean validateName(String Name)
	{
		if(Name.matches("^[A-Z][a-z]{2,29}( [A-Z][a-z]{2,29})*$")) 
		{
			return true;
		}
		System.out.println("Name is not valid");
		return false;
	}

}
