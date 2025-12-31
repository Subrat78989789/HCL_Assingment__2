package emp_Management;

import java.util.Map;
import java.util.Set;
import java.util.Iterator;

public class EmployeeServiceImplementation implements EmployeeService {

	//Using Map Interface
	private Map<String, Employee> map;
	Employee_Validation eValidation=new Employee_Validation();
	public EmployeeServiceImplementation(Map<String,Employee> map) 
	{
	this.map=map;
	}
	@Override
	public void addEmployee(Employee e)throws Exception {
		 if (e==null || !eValidation.Employee_Id(e.getEmp_id()))//Checking/Demonstrating the null key and null value support
		 {
	           throw new Employee_Exception("Invalid Employee");
	            
		 }  
		map.put(e.getEmp_id(), e);
		
	}

	@Override
	public void displayEmployees() {
		// TODO Auto-generated method stub
		 if (map.isEmpty()) {
	            System.out.println("No records found");
	            return;
	        }
			
			Set<Map.Entry<String, Employee>> set=map.entrySet();
			Iterator<Map.Entry<String,Employee>> it=set.iterator();
			while(it.hasNext())
			{
				Map.Entry<String, Employee> traverse=it.next();
				System.out.println("Employee Name:"+traverse.getValue().getEmp_name());//value is object and object consist employee
				System.out.println("Employee ID:"+traverse.getValue().getEmp_id());
				System.out.println("Employee Salary:"+traverse.getValue().getSalary());
				System.out.println();
			}
	
	}

	@Override
	public void searchEmployee(String emp_id)throws Exception{
		
		if(map.containsKey(emp_id))
		{
		System.out.println("Employee is founded");
		}
		else {
			  throw new Employee_Exception("Invalid Employee");
		}
		
	}

	@Override
	public void removeEmployee(String emp_id)throws Exception {
		if(map.containsKey(emp_id))
		{
			map.remove(emp_id);
		}
		else {
			  throw new Employee_Exception("Invalid Employee");
		}
			// TODO Auto-generated method stub
		
	}

}
