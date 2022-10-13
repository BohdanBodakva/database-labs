package ua.lviv.iot.database.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.lviv.iot.database.lab4.models.Medicine;
import ua.lviv.iot.database.lab4.view.View;

@SpringBootApplication
public class Lab4Application implements CommandLineRunner {

	@Autowired
	private View view;

	public static void main(String... args) {
		SpringApplication.run(Lab4Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		view.da("ko");
	}

}
