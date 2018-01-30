package pl.alor.sales;

import org.junit.Test;
import org.junit.Assert;
import pl.alor.repository.ProductData;

public class ProductTest
	{
	@Test
	public void canCreateOutOfStockProduct()
		{
		ProductData productData = new ProductData("92939495", "lego 9293", (short)12);
		Product product = new Product(productData);
		
		Assert.assertFalse(product.isInStock());
		}
	
	@Test
	public void itStoresCorrectStockValues()
		{
		ProductData productData = new ProductData("92939495", "lego 9293", (short)12);
		Product product = new Product(productData, (short)3);
		
		if(product.isInStock((short)3)) Assert.assertFalse(product.isInStock((short)4));
		}	
	
	@Test
	public void itStoresCorrectId()
		{
		ProductData productData = new ProductData("92939495", "lego 9293", (short)12);
		Product product = new Product(productData, (short)12);
		Assert.assertEquals("92939495", product.getId());
		}

	@Test
	public void canTakeOneProduct()
		{
		ProductData productData = new ProductData("92939495", "lego 9293", (short)12);
		Product product = new Product(productData, (short)1);
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
		ProductData productData = new ProductData("92939495", "lego 9293", (short)12);
		Product product = new Product(productData, (short)8);
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
		ProductData productData = new ProductData("92939495", "lego 9293", (short)12);
		Product product = new Product(productData, (short)0);
		Boolean threw = false;
		try
			{
			product.take();
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
		ProductData productData = new ProductData("92939495", "lego 9293", (short)12);
		Product product = new Product(productData);
		product.put();
		if(product.isInStock()) Assert.assertFalse(product.isInStock((short)2));
		else Assert.assertFalse(true);
		}
	
	@Test
	public void canPutMoreProduct()
		{
		ProductData productData = new ProductData("92939495", "lego 9293", (short)12);
		Product product = new Product(productData, (short)2);
		product.put((short)6);
		if(product.isInStock((short)8)) Assert.assertFalse(product.isInStock((short)9));
		else Assert.assertFalse(true);
		}
	}
