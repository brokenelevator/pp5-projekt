package pl.alor.websiteController;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import pl.alor.repository.ProductCatalog;
import pl.alor.repository.ProductData;

@Controller
public class ProductController
	{
	@RequestMapping("/products")
	@ResponseBody
	public Collection<ProductData> jsonProducts()
		{
		ProductCatalog catalog = new ProductCatalog();
		catalog.parseDataFile();
		return catalog.getCatalog().values();
		}
	}