package pl.alor.sales;

import java.util.HashMap;

public class Basket
	{
	private final HashMap<Product, Integer> contents;

	public Basket()
		{
		this.contents = new HashMap<Product, Integer>();
		}

	public void add(Product product) throws ProductNotAvailableException
		{
		add(product, 1);
		}

	public void add(Product product, Integer number) throws ProductNotAvailableException
		{
		product.take(number.shortValue());
		if(!contents.containsKey(product)) contents.put(product, number);
		else contents.replace(product, productCount(product)+number);
		}

	public boolean isEmpty()
		{
		return contents.isEmpty();
		}

	public int productsCount()
		{
		return contents.size();
		}
	
	public int productCount(Product product)
		{
		return contents.getOrDefault(product, 0);
		}
		
	public HashMap<Product, Integer> getItems()
		{
		return contents;
		}
	}
