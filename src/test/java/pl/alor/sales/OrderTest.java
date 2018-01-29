package pl.alor.sales;

import org.junit.Test;
import org.junit.Assert;

public class OrderTest
	{
	@Test
	public void calculatesOrderOfSingleTypeItem()
		{
		Product product1 = new Product("lego 9293", (short)12, (short)12);
		Basket basket = new Basket();
		try
			{
			basket.add(product1, 12);
			}
		catch(Exception e) {}
		Order order = new Order(basket);
		Assert.assertEquals(144, order.calculateTotal());
		}
	
	@Test
	public void calculatesOrderOfMultipleTypeItem()
		{
		Product product1 = new Product("lego 9293", (short)4, (short)5);
		Product product2 = new Product("lego 9394", (short)7, (short)3);
		Product product3 = new Product("lego 9495", (short)9, (short)1);
		Product product4 = new Product("lego 9596", (short)12, (short)4);
		Basket basket = new Basket();
		try
			{
			basket.add(product1, 5);
			basket.add(product2, 3);
			basket.add(product3, 1);
			basket.add(product4, 4);
			}
		catch(Exception e) {}
		Order order = new Order(basket);
		Assert.assertEquals(98, order.calculateTotal());
		}
	
	@Test
	public void calculatesSingleTypeItemWithDiscount()
		{
		Product product1 = new Product("lego 9293", (short)12, (short)12);
		Basket basket = new Basket();
		try
			{
			basket.add(product1, 12);
			}
		catch(Exception e) {}
		Discount discount = new Discount((short)4);
		Order order = new Order(basket, discount);
		Assert.assertEquals(108, order.calculateTotal());
		}
	
	@Test
	public void calculatesMultipleTypeItemWithDiscount()
		{
		Product product1 = new Product("lego 9293", (short)4, (short)5);
		Product product2 = new Product("lego 9394", (short)7, (short)3);
		Product product3 = new Product("lego 9495", (short)9, (short)1);
		Product product4 = new Product("lego 9596", (short)12, (short)4);
		Basket basket = new Basket();
		try
			{
			basket.add(product1, 5);
			basket.add(product2, 3);
			basket.add(product3, 1);
			basket.add(product4, 4);
			}
		catch(Exception e) {}
		Discount discount = new Discount((short)4);
		Order order = new Order(basket, discount);
		Assert.assertEquals(82, order.calculateTotal());
		}
	
	@Test
	public void calculatesWithCompleteDiscount()
		{
		Product product1 = new Product("lego 9293", (short)4, (short)5);
		Product product2 = new Product("lego 9394", (short)7, (short)3);
		Product product3 = new Product("lego 9495", (short)9, (short)1);
		Product product4 = new Product("lego 9596", (short)12, (short)4);
		Basket basket = new Basket();
		try
			{
			basket.add(product1, 5);
			basket.add(product2, 3);
			basket.add(product3, 1);
			basket.add(product4, 4);
			}
		catch(Exception e) {}
		Discount discount = new Discount((short)1);
		Order order = new Order(basket, discount);
		Assert.assertEquals(0, order.calculateTotal());
		}
	}
