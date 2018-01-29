package pl.alor.sales;

public class Product
	{
	private short stockQty;
	private String name;
	private short price;

	public Product(String name, short price, short stockQty)
		{
		this.stockQty = stockQty;
		this.name = name;
		this.price = price;
		}

	public Product(String name, short price)
		{
		this(name, price, (short)0);
		}
		
	public String getName()
		{
		return name;
		}
		
	public short getPrice()
		{
		return price;
		}

	public boolean isInStock()
		{
		return stockQty > 0;
		}

	public boolean isInStock(short number)
		{
		return stockQty > (number - 1);
		}

	public void take() throws ProductNotAvailableException
		{
		take((short)1);
		}
	
	public void take(short number) throws ProductNotAvailableException
		{
		if(!isInStock(number)) throw new ProductNotAvailableException();
		else stockQty -= number;
		}
	
	public void put()
		{
		put((short)1);
		}
	
	public void put(short number)
		{
		stockQty += number;
		}
	}

class ProductNotAvailableException extends Exception {}
