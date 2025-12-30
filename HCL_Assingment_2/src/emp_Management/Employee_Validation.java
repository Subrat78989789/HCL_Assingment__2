package emp_Management;

public class Employee_Validation {
	public boolean Employee_Id(String id)
	{
		String regx="^EMP\\d{3,}$";
		if(id.matches(regx))
		{
			return true;
		}
		return false;
	}

}
