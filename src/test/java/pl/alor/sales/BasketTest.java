package pl.alor.sales;

import org.junit.Test;
import org.junit.Assert;

public class BasketTest
	{
	@Test
	public void itAllowAddProductToBasket()
		{
		Product product1 = new Product("92939495", (short)12, (short)1);
		
		Basket basket = new Basket();
		try
			{
			basket.add(product1);
			}
		catch(Exception e) {}

		Assert.assertTrue(basket.productCount(product1) == 1 && basket.productsCount() == 1);
		}

	@Test
	public void itAllowAddMultipleProduct()
		{
		Product product1 = new Product("92939495", (short)12, (short)1);
		Product product2 = new Product("13111412", (short)12, (short)1);
		Product product3 = new Product("13121413", (short)12, (short)1);
		
		Basket basket = new Basket();
		try
			{
			basket.add(product1);
			basket.add(product2);
			basket.add(product3);
			}
		catch(Exception e) {}

		Assert.assertEquals(3, basket.productsCount());
		}

	@Test
	public void itAllowAddMultipleProductSameType()
		{
		Product product1 = new Product("92939495", (short)12, (short)3);
		
		Basket basket = new Basket();
		try
			{
			basket.add(product1, 3);
			}
		catch(Exception e) {}

		Assert.assertEquals(1, basket.productsCount());
		}
	
	@Test
	public void itStoresNumberProductSameType()
		{
		Product product1 = new Product("92939495", (short)12, (short)3);
		
		Basket basket = new Basket();
		try
			{
			basket.add(product1, 3);
			}
		catch(Exception e) {}

		Assert.assertEquals(3, basket.productCount(product1));
		}
	
	@Test
	public void addingNotAvailableProductDoesNotChangeBasketContents()
		{
		Product product1 = new Product("92939495", (short)12, (short)0);
		Basket basket = new Basket();
		try
			{
			basket.add(product1);
			}
		catch(Exception e) {}
		Assert.assertTrue(basket.isEmpty());
		}

	@Test
	public void itCanBeEmpty()
		{
		Basket basket = new Basket();
		Assert.assertTrue(basket.isEmpty());
		}
	}
