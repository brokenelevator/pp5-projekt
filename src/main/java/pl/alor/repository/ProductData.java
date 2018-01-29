package pl.alor.repository;

public class ProductData
	{
	private String id;
	private String name;
	private String image;
	private short price;
	private String description; 
	
	public ProductData(String id, String name, String image, short price, String description)
		{
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.description = description;
		}

	public ProductData(String id, String name, short price, String description)
		{
		this(id, name, "", price, description);
		}

	public ProductData(String id, String name, String image, short price)
		{
		this(id, name, image, price, "");
		}

	public ProductData(String id, String name, short price)
		{
		this(id, name, "", price, "");
		}

	public String getId()
		{
		return id;
		}

	public void setId(String id)
		{
		this.id = id;
		}

	public String getName()
		{
		return name;
		}

	public void setName(String name)
		{
		this.name = name;
		}

	public String getImage()
		{
		return image;
		}

	public void setImage(String image)
		{
		this.image = image;
		}

	public short getPrice()
		{
		return price;
		}

	public void setPrice(short price)
		{
		this.price = price;
		}

	public String getDescription()
		{
		return description;
		}

	public void setDescription(String description)
		{
		this.description = description;
		}
	}
