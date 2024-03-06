package com.example.database;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.java.Log;

@Log
@SpringBootApplication
public class DatabaseApplication {
	// application.properties dosyasındda database bağlantı konfigürasyonları var.
	// docker bağlamak için docker-compose.yml dosyası oluşturduktan sonra docker-compose up komutu çalıştırıldı.


	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}



}
