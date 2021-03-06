package pl.alor.repository;

import java.util.HashMap;
import java.io.InputStreamReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import com.opencsv.CSVIterator;

public class ProductCatalog
	{
	private HashMap<String, ProductData> catalog;
	
	public ProductCatalog()
		{
		this.catalog = new HashMap<String, ProductData>();
		}

	public HashMap<String, ProductData> getCatalog()
		{
		return catalog;
		}

	public ProductData getProductById(String id)
		{
		return catalog.get(id);
		}

	public void parseDataFile()
		{
		InputStreamReader reader = new InputStreamReader(ProductCatalog.class.getResourceAsStream("/static/ProductCatalogDataFile.csv"));
		CSVIterator iterator;
		try
			{
			iterator = new CSVIterator(new CSVReader(reader));
			}
		catch(IOException e)
			{
			return;
			}
		HashMap<String, ProductData> tmp = new HashMap<String, ProductData>();
		while(iterator.hasNext())
			{
			String[] nextLine = iterator.next();
			//			id							id				name		image						price			description
			tmp.put(nextLine[0], new ProductData(nextLine[0], nextLine[1], nextLine[2], Short.parseShort(nextLine[3]), nextLine[4]));
			}
		catalog = tmp;
		}
	}
