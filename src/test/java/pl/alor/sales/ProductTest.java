package pl.alor.sales;

import org.junit.Test;
import org.junit.Assert;

public class ProductTest
	{
	@Test
	public void canCreateOutOfStockProduct()
		{
		Product product = new Product("lego 9293");
		
		Assert.assertFalse(product.isInStock());
		}
	
	@Test
	public void itStoresCorrectStockValues()
		{
		Product product = new Product("lego 9293", (short)3);
		
		if(product.isInStock((short)3)) Assert.assertFalse(product.isInStock((short)4));
		}	
	
	@Test
	public void itStoresCorrectName()
		{
		Product product = new Product("lego 9293");
		Assert.assertEquals("lego 9293", product.getName());
		}

	@Test
	public void canTakeOneProduct()
		{
		Product product = new Product("lego 9293", (short)1);
		Boolean pass = false;
		try
			{
			product.take();
			pass = true;
			}
		catch(Exception e) {}
		if(pass) Assert.assertFalse(product.isInStock());
		else Assert.assertFalse(true);
		}

	@Test
	public void canTakeMoreProduct()
		{
		Product product = new Product("lego 9293", (short)8);
		Boolean pass = false;
		try
			{
			product.take((short)4);
			pass = true;
			}
		catch(Exception e) {}
		if(pass)
			{
			if(product.isInStock((short)4)) Assert.assertFalse(product.isInStock((short)5));
			else Assert.assertFalse(true);
			}
		else Assert.assertFalse(true);
		}

	@Test
	public void itThrowsWhenNotAvailable()
		{
		Product product1 = new Product("lego 9293", (short)0);
		Boolean threw = false;
		try
			{
			product1.take();
			}
		catch(Exception e)
			{
			threw = true;
			}
		Assert.assertTrue(threw);
		}
	
	@Test
	public void canPutOneProduct()
		{
		Product product = new Product("lego 9293");
		product.put();
		if(product.isInStock()) Assert.assertFalse(product.isInStock((short)2));
		else Assert.assertFalse(true);
		}
	
	@Test
	public void canPutMoreProduct()
		{
		Product product = new Product("lego 9293", (short)2);
		product.put((short)6);
		if(product.isInStock((short)8)) Assert.assertFalse(product.isInStock((short)9));
		else Assert.assertFalse(true);
		}
	}
