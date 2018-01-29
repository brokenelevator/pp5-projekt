package pl.alor.sales;

public class Discount
	{
	private short everyXFree;

	public Discount(short every)
		{
		this.everyXFree = every;
		}
	
	public void setAmount(short every)
		{
		everyXFree = every;
		}	

	public short getAmount()
		{
		return everyXFree;
		}
	}
