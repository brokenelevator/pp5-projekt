package pl.alor.sales;

import org.junit.Test;
import org.junit.Assert;
import pl.alor.repository.ProductData;

public class OrderTest
	{
	@Test
	public void calculatesOrderOfSingleTypeItem()
		{
		ProductData productData1 = new ProductData("92939495", "lego 9293", (short)12);
		Product product1 = new Product(productData1, (short)12);
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
		ProductData productData1 = new ProductData("92939495", "lego 9293", (short)4);
		Product product1 = new Product(productData1, (short)5);
		ProductData productData2 = new ProductData("93949596", "lego 9394", (short)7);
		Product product2 = new Product(productData2, (short)3);
		ProductData productData3 = new ProductData("94959697", "lego 9495", (short)9);
		Product product3 = new Product(productData3, (short)1);
		ProductData productData4 = new ProductData("95969798", "lego 9596", (short)12);
		Product product4 = new Product(productData4, (short)4);
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
		ProductData productData1 = new ProductData("92939495", "lego 9293", (short)12);
		Product product1 = new Product(productData1, (short)12);
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
		ProductData productData1 = new ProductData("92939495", "lego 9293", (short)4);
		Product product1 = new Product(productData1, (short)5);
		ProductData productData2 = new ProductData("93949596", "lego 9394", (short)7);
		Product product2 = new Product(productData2, (short)3);
		ProductData productData3 = new ProductData("94959697", "lego 9495", (short)9);
		Product product3 = new Product(productData3, (short)1);
		ProductData productData4 = new ProductData("95969798", "lego 9596", (short)12);
		Product product4 = new Product(productData4, (short)4);
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
		ProductData productData1 = new ProductData("92939495", "lego 9293", (short)4);
		Product product1 = new Product(productData1, (short)5);
		ProductData productData2 = new ProductData("93949596", "lego 9394", (short)7);
		Product product2 = new Product(productData2, (short)3);
		ProductData productData3 = new ProductData("94959697", "lego 9495", (short)9);
		Product product3 = new Product(productData3, (short)1);
		ProductData productData4 = new ProductData("95969798", "lego 9596", (short)12);
		Product product4 = new Product(productData4, (short)4);
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
