package pl.alor.sales;

public class Product
	{
	private short stockQty;

	public Product(String name, short stockQty)
		{
		this.stockQty = stockQty;
		}

	public Product(String name)
		{
		this.stockQty = 0;
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
	
	public void putBack()
		{
		putBack((short)1);
		}
	
	public void putBack(short number)
		{
		stockQty += number;
		}
	}

class ProductNotAvailableException extends Exception {}
