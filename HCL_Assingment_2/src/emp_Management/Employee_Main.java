package emp_Management;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.TreeMap;

public class Employee_Main{
	public static void main(String[] args) {
		try {
		Scanner sc=new Scanner(System.in);
		//HashMap<String, Employee> hmap=new HashMap<>();//Allows 1 null key & multiple null values
		//or
		//Hashtable<String, Employee> hmap=new Hashtable<>();//Allows no null key, no null value
		//or
		TreeMap<String, Employee>hmap=new TreeMap<>();//Allows null value, no null key,sorted order is maintained
		EmployeeServiceImplementation e=new EmployeeServiceImplementation(hmap);
		Employee_Validation eValidation=new Employee_Validation();
	int key=0;
do {
	System.out.println("#######Employee Management#######");
	System.out.println("1.Add Employee");
	System.out.println("2.Display Employees");
	System.out.println("3.Search Employee");
	System.out.println("4.Remove Employee");
	System.out.println("5.Exit");
	System.out.print("Enter Your Choice:");
	 key=sc.nextInt();
	
	switch (key) {
	case 1:Employee em=new Employee();
	System.out.println("Enter Emp_Id:");
	sc.nextLine();
	String emp_id=sc.nextLine();
	
		em.setEmp_id(emp_id);
	
	System.out.println("Enter Emp_Name:");
	String emp_name=sc.nextLine();
	em.setEmp_name(emp_name);
	System.out.println("Enter emp_salary:");
	double emp_salary=sc.nextDouble();
	em.setSalary(emp_salary);
	sc.nextLine();
	e.addEmployee(em);
	//or
	//e.addEmployee(new Employee("Emp121","Subh",58963); for this i have to make constructor in employee class and then set the elements in that constructor
	break;
	case 2: e.displayEmployees();break;
	case 3:
		System.out.print("Enter Emp_Id:");
		sc.nextLine();
		
		String emp_iid=sc.nextLine();
		e.searchEmployee(emp_iid);
		break;
	case 4:
		System.out.print("Enter Emp_Id:");
		sc.nextLine();
		String emp_iiid=sc.nextLine();
		e.removeEmployee(emp_iiid);
		break;
	
	default:
		throw new IllegalArgumentException("Unexpected value: " + key);
	}
}
	while(key>0 && key<5);
		}
		catch (Exception e2) {
			System.out.println(e2);
		}
		
		
	}

}
