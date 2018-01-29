package pl.alor.repository;

import java.util.HashMap;
import java.io.FileReader;
import java.io.FileNotFoundException;
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

	public ProductData getProductById(String id)
		{
		return catalog.get(id);
		}

	public void parseDataFile()
		{
		FileReader reader;
		CSVIterator iterator;
		try
			{
			reader = new FileReader("src/main/resources/static/ProductCatalogDataFile.csv");
			iterator = new CSVIterator(new CSVReader(reader));
			}
		catch(FileNotFoundException e)
			{
			return;
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
