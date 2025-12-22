package regex;


import java.util.Scanner;

public class Strings_Validations {
	static Scanner sc=new Scanner(System.in);
	static String test_String;
	public static void  validateMobileNumber()
	{
		// sc=new Scanner(System.in);
		System.out.print("Enter Phone Number: ");
		long ph_number=sc.nextLong();
		test_String=String.valueOf(ph_number);
		boolean b=test_String.matches("^[6-9][0-9]{9}$");
		if(b)
		{
			System.out.println("Mobile number is valid");
		}
		else {
			System.out.println("Mobile number is not valid");
		}
	
		
	}
	public static void validateEmailId()
	{
		// sc=new Scanner(System.in);
		System.out.print("Enter Email Id: ");
	sc.nextLine();
		test_String=sc.nextLine();
		
		boolean b=test_String.matches("^[a-zA-Z0-9.%_+-]+@[a-zA-Z0-9-.]+\\.[a-zA-Z]{2,}$");
		if(b)
		{
			System.out.println("Email Id is valid");
		}
		else {
			System.out.println("Email Id is not valid");
		}

	}
	public static void  validateUsername()
	{
		// sc=new Scanner(System.in);
		System.out.print("Enter Usename: ");
		sc.nextLine();
		test_String=sc.nextLine();
		
		boolean b=test_String.matches("^[A-Za-z0-9_]{5,}");
		if(b)
		{
			System.out.println("Username is valid");
			
		}
		else {
			System.out.println("Username is not valid");
		}

	}
	public static void validatePassword()
	{
	//	 sc=new Scanner(System.in);
       System.out.print("Enter Password: ");
		sc.nextLine();
		test_String=sc.nextLine();
		boolean b=test_String.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%!]).{8,}$");
		if(b)
		{
			System.out.println("Password is valid");
		}
		else {
			System.out.println("Password is not valid");
		}
	
	}
	public static void main(String[] args) {
		
	
		int choice=0;
	do {
		System.out.println();
		System.out.println("------Validations------");
		System.out.println("1.Mobile Number Validation");
		System.out.println("2.Email Id Validation");
		System.out.println("3.Usename Validation");
		System.out.println("4.Password Validation");
		System.out.println("5.Exit");
	
		System.out.print("Enter Your Choice: ");
		// sc=new Scanner(System.in);
	
	    choice=sc.nextInt();
		
		
	    switch (choice) {
		case 1:validateMobileNumber();break;
		case 2:validateEmailId();break;
		case 3:validateUsername();break;
		case 4:validatePassword();break;
	    
		default:
		try {
			throw new IllegalArgumentException("Programm is finished due to Unexpected value: " + choice);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		}
	}
	 while(choice<5);
		
//	✅ Correct rule for exams & real projects
//
//	✔ If Scanner uses System.in → DO NOT close it
//	✔ Let JVM close it automatically when program ends
	}
}
