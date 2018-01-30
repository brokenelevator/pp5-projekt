package pl.alor.sales;

import org.junit.Test;
import org.junit.Assert;
import pl.alor.repository.ProductData;

public class BasketTest
	{
	@Test
	public void itAllowAddProductToBasket()
		{
		ProductData productData1 = new ProductData("92939495", "lego 9293", (short)12);
		Product product1 = new Product(productData1, (short)1);
		
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
		ProductData productData1 = new ProductData("92939495", "lego 9293", (short)12);
		Product product1 = new Product(productData1, (short)1);
		ProductData productData2 = new ProductData("13111412", "lego 1311", (short)12);
		Product product2 = new Product(productData2, (short)1);
		ProductData productData3 = new ProductData("13121413", "lego 1312", (short)12);
		Product product3 = new Product(productData3, (short)1);
		
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
		ProductData productData1 = new ProductData("92939495", "lego 9293", (short)12);
		Product product1 = new Product(productData1, (short)3);
		
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
		ProductData productData1 = new ProductData("92939495", "lego 9293", (short)12);
		Product product1 = new Product(productData1, (short)3);
		
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
		ProductData productData1 = new ProductData("92939495", "lego 9293", (short)12);
		Product product1 = new Product(productData1, (short)0);
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
