package com.Conversor.Moedas;

import com.Conversor.Moedas.Main.Main;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoversorDeMoedasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CoversorDeMoedasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.Comecar();
	}
}
