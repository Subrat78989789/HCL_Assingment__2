package student_handling;

import java.util.*;

public class Student_Service extends StudentValidation implements StudentOperations {
	
List<Student> stu_list=new ArrayList<>();

static Scanner sc=new Scanner(System.in);//this scanner object is static thats why it is accessible by anyone inside this class without using any class object
@Override
	public  void addStudents(Student s)
    {
	/*stu_list.add(new Student("Alice", 101, "A"));
        stu_list.add(new Student("Bob", 102, "B"));
       stu_list.students.add(new Student("Charlie", 103, "C"));*/
	
	//OR Above way also we can use
	
	String roll_no;
    String name;
		do {
			System.out.print("Enter Valid Student Roll_No: ");
			roll_no=sc.nextLine();
			s.setRollno(roll_no);
		}
		while(!validateRollNo(roll_no));//This will be infinite till correct roll number is not inputed
	     
		do {
	     System.out.print("Enter Student Name: ");
	      name=sc.nextLine();
	      s.setName(name);
		}
		while(!validateName(name));
	    
	 	
	 	System.out.print("Enter Student Age: ");
	 	int age=sc.nextInt();
	 	sc.nextLine();//if you track the input buffer of scanner object sc then you can realize that it is needed here
	 	
	 	s.setAge(age);
	 	stu_list.add(s);
	     }
	     
	
	
	
	
		
	
	
@Override
	public void displayStudents() {
		Iterator<Student> traverse=stu_list.iterator();
		System.out.println("****Student Details****");
		while(traverse.hasNext())
		{
			//iterator always behind one step of object in collection to traverse the collection we have to move the iterator to next one step by using next() 
			Student currentStudent=traverse.next();
		
			System.out.println("Student Name :"+currentStudent.getName());
			System.out.println("Student Age :"+currentStudent.getAge());
			System.out.println("Student RollNumber :"+currentStudent.getRollno());
			System.out.println();
			
		}
		
	}
@Override
	public void removeByRoll()throws StudentNotFoundException {
	
		System.out.print("Enter Roll Number: ");
		
		String Roll_no=sc.nextLine();
		boolean check=true;
	if(validateRollNo(Roll_no))
	{
		for(Student sr:stu_list)
		{
		if(sr.getRollno().equals(Roll_no))
		{
			System.out.println("Student whose Roll_no number is:"+sr.getRollno()+" has been Removed");
			stu_list.remove(sr);
			check=false;
			break;
		}
		}
		if(check)
		{
			throw new StudentNotFoundException(Roll_no);
		}
	
	}
	else {
		throw new StudentNotFoundException(Roll_no);
	}
	
		
	}

@Override
	public void searchByRoll()throws StudentNotFoundException{

	System.out.print("Enter Roll Number: ");

	String Roll_no=sc.nextLine();
	boolean check=true;
	if(validateRollNo(Roll_no))
	{
		for(Student sr:stu_list)
		{
		if(sr.getRollno().equals(Roll_no))
		{
			System.out.println("Student Name: "+sr.getName());
			System.out.println("Student Age: "+sr.getAge());
			System.out.println("Student Roll_No: "+sr.getRollno());
			check=false;
			break;
			
		}
	
		}
		if(check)
		{
			throw new StudentNotFoundException(Roll_no);
		}

		
	
	}
	else {
		throw new StudentNotFoundException(Roll_no);
		}
	
	}
		
		
	}



