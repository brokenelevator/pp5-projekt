package pl.alor.sales;

import pl.alor.repository.ProductData;

public class Product
	{
	private short stockQty;
	private String id;
	private short price;

	public Product(ProductData product, short stockQty)
		{
		this.stockQty = stockQty;
		this.id = product.getId();
		this.price = product.getPrice();
		}

	public Product(ProductData product)
		{
		this(product, (short)0);
		}
		
	public String getId()
		{
		return id;
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
