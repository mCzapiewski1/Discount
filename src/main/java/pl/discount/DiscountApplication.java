package pl.discount;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import pl.discount.controller.FilesController;

@ComponentScan("pl.discount.*")
@SpringBootApplication
public class DiscountApplication {

	public static void main(String[] args) {
		new File(FilesController.uploadDirectory).mkdir();
		SpringApplication.run(DiscountApplication.class, args);
	}

}
