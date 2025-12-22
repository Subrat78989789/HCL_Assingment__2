package Banking;

import java.util.Scanner;

public class BankAccount implements BankingOperations,CustomOperations 
{
	private String name;
	private long accountNumber;
	private double balance;
	private double amount;
	private boolean validation=false;
	Scanner scanner=new Scanner(System.in);
	
	
	@Override
	public void deposit()throws IllegalArgumentException
	{
		if(validation)
		{
		System.out.print("Enter deposit amount= ");
		amount=scanner.nextDouble();
		if(amount>=0)
		{
		balance=balance+amount;
		System.out.println("Amount is deposited Now your balance is: "+balance);
		}
		else {
			throw new IllegalArgumentException("Amount is not valid Operation is failed");
		}
		}
		else {
			System.out.println("Your Account doesn't exist");
		}
		
	}
	@Override
	public void withdraw() throws InsufficientFundException {
		if(validation)
		{
		System.out.print("Enter withdrawl amount= ");
		amount=scanner.nextDouble();
		if(balance>=amount)
		{
		balance=balance-amount;
		System.out.println("Amount is withdrawn Left balance is: "+balance);
		}
		else {
			throw new InsufficientFundException("Insufficient Fund Transaction is failed");
		}
		}
		else {
			System.out.println("Your Account doesn't exist");
		}
	}
	@Override
	public double getBalance() {
		// TODO Auto-generated method stub
		
		return balance;
	}
	@Override
	public void setCustomerDetails() {
		System.out.print("Enter Account Holder Name: ");
		name=scanner.nextLine();
		System.out.print("Enter Account Holder AccountNumber: ");
		accountNumber=scanner.nextLong();
		System.out.println("*****Account Successfully Created*****");
		validation=true;
		
		
	}
	@Override
	public void dispalyDetails() {
		System.out.println("Customer Name= "+this.name);
		System.out.println("Customer Acount Number= "+this.accountNumber);
		
		
	}

}
