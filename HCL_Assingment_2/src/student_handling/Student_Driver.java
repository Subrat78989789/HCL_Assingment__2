package student_handling;


import java.util.InputMismatchException;
import java.util.Scanner;
//Note
//Key rule in Java (very important)
//Variable type	Default value
//Local variable	❌ NO default value
//Instance variable	✔ default (0, null, false)
//Static variable	✔ default (0, null, false)


public class Student_Driver extends Student_Service {
	
	//static int choice;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Student_Service service=new Student_Service();
		Student student;
		int choice=0;
		 
	
		do {
			System.out.println("----------Menu----------");
			System.out.println("1.Register Student");
			System.out.println("2.Display All Students Details");
			System.out.println("3.Remove Students");
			System.out.println("4.Display Student Detail");
			System.out.println("5.Exit");
			System.out.print("Enter your Choice: ");
			
		try {
		 choice=sc.nextInt();

				
				 //Student RollNumber regexp->^STU[0-9]{3}$
			 //Student Name regexp->^[A-Z][a-z]{2,29}( [A-Z][a-z]{2,29})*$
			switch(choice)
			{
			case 1: student=new Student();
				service.addStudents(student);
				break;
				
			case 2: service.displayStudents();
			 break;
			 
			 
			case 3:
				try {
				service.removeByRoll();
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			break;
			
			
			case 4:
				try {
				service.searchByRoll();
			}
			catch(StudentNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
			break;
			
			case 5:System.out.println("Invalid Choice Exit...");
			break;
			default: throw new Exception("Invalid Choice Exit from programm");
				}
		//	throw new InputMismatchException("Input is mismatched Insert valid input in choice");
			//the above throw exception is executed unnecessary for valid inputs also if you observe the code flow therefore it is not required
			//whenever input mismatch exception occur during mismatch input to choice variable(instead of passing integer, string or character is passed) then JVM jumps directly to catch(block) now catch block handled the exception and due to this the above throw has not executed and it is ignored
		}
		
		catch (InputMismatchException e) 
		{
			System.out.println("Invalid Input Try Again");
			sc.nextLine();//clear wrong input from buffer for updating choice variable
			//if we will not clear wrong input buffer then each time input will be taken as that input which is present in buffer
			//for example->if inputed "abc" and we know sc.nextInt() will throw input mismatch exception now still the input buffer of scanner object sc contain the "abc" in buffer know we have to clear it so that next input can be taken for choice variable
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		}
		while(choice<5);//after encountering exception also this while loop executed because choice variable is earlier initialized with zero therefore 0<5 condition works and while loop executed
				
		
		//If we handle exception outside while loop then while loop get terminated.
		}
		
		
		
	}

		
			
			
			
		
		
		
	
	

