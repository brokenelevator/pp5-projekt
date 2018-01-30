package pl.alor.websiteController;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.ComponentScan;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class MainController
	{
	public static void main(String[] args) throws Exception
		{
		SpringApplication.run(MainController.class, args);
		}
	}