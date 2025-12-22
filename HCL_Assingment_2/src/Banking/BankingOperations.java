package Banking;

public interface BankingOperations {

	public void deposit()throws IllegalArgumentException;
	public void withdraw()throws InsufficientFundException;
	public double getBalance();
	
}
