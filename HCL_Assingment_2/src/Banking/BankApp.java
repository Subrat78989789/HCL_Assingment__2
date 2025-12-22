package Banking;

import java.util.Scanner;





public class BankApp {
	public static void main(String[] args) {
		
	BankAccount b=new BankAccount();
	Scanner sc=new Scanner(System.in);
	int choice;
	do {
		System.out.println();
		System.out.println("------Bank Menu------");
		System.out.println("1.Create Account");
		System.out.println("2.Display Account Details");
		System.out.println("3.Dispaly Balance");
		System.out.println("4.Deposit Money");
		System.out.println("5.Withdraw Money");
		System.out.println("6.Exit");
		System.out.print("Enter Your Choice: ");
		 choice=sc.nextInt();
		switch(choice) {
		case 1:b.setCustomerDetails();break;
		case 2:b.dispalyDetails();break;
		case 3:System.out.println("Account Balance is: "+b.getBalance());break;
		case 4:
			try {
			b.deposit();
			}
			catch (Exception e) {
			System.out.println(e.getMessage());
				
			}
			break;
			
			
		case 5:try {
			b.withdraw();
		}
		catch(InsufficientFundException e)
		{
		System.out.println(e.getMessage());
		}
			break;
		
		default:System.out.println("Invalid Choice");break;
		
		}
	}
	while(choice!=6);
	}
}
