package pl.alor.sales;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Order
	{
	private final HashMap<Product, Integer> items;
	private final short discount;
	
	public Order(Basket basket)
		{
		items = basket.getItems();
		discount = 0;
		}
	
	public Order(Basket basket, Discount discount)
		{
		items = basket.getItems();
		this.discount = discount.getAmount();
		}
	
	public int calculateTotal()
		{
		AtomicInteger subTotal = new AtomicInteger();
		items.forEach((product, quantity) -> 
			{
			int free = 0;
			if(discount > 0) free = quantity / discount;
			subTotal.getAndAdd((quantity - free) * product.getPrice());
			});
		return subTotal.intValue();
		}
	}
