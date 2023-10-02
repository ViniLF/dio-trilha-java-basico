package com.apiclima.apiclima;

import com.apiclima.services.WeatherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ApiClimaApplicationTests {

	@Autowired
	private WeatherService weatherService;

	@Test
	void contextLoads() {
		assertNotNull(weatherService, "WeatherService não foi injetado corretamente.");
	}

	@Test
	void testObterClima() {
		// Teste para o método obterClima do WeatherService
		String cidade = "Loanda";
		String clima = weatherService.obterClima(cidade);

		assertNotNull(clima, "O clima não pode ser nulo.");
	}
}
