package pl.alor.repository;

import org.junit.Test;
import org.junit.Assert;

public class ProductCatalogTest
	{
	@Test
	public void canParseDataFile()
		{
		ProductCatalog productCatalog = new ProductCatalog();
		productCatalog.parseDataFile();
		ProductData productData = productCatalog.getProductById("92939495");
		Assert.assertEquals("lego 9293", productData.getName());
		Assert.assertEquals("lego9293.png", productData.getImage());
		Assert.assertEquals(20, productData.getPrice());
		Assert.assertEquals("Coolest Lego Ever", productData.getDescription());
		}
	}
