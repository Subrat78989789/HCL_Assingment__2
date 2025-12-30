package emp_Management;

public interface EmployeeService {
	public void addEmployee(Employee e) throws Exception;
	public void displayEmployees();
	public void searchEmployee(String emp_id) throws Exception;
	public void removeEmployee(String emp_id) throws Exception;
	
}
