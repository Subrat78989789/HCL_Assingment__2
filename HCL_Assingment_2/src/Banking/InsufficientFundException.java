package Banking;

public class InsufficientFundException extends Exception
{
	private String message;
	public InsufficientFundException(String message) 
	{
		//super(message);
		this.message=message;
		
		
	}
	@Override
	public String getMessage()
	{
		return message;
	}

}
