package com.apiclima.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${openweathermap.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    private static final String TEMPERATURE_KEY = "temp";
    private static final String DESCRIPTION_KEY = "description";
    private static final String HUMIDITY_KEY = "humidity";
    private static final String PRESSURE_KEY = "pressure";

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String obterClima(String cidade) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" + cidade + "&appid=" + apiKey;

        try {
            String resposta = restTemplate.getForObject(url, String.class);
            return construirMensagemClima(cidade, resposta);
        } catch (Exception e) {
            return "Erro ao obter informações de clima.";
        }
    }

    private String construirMensagemClima(String cidade, String resposta) {
        String temperatura = extrairInformacao(resposta, TEMPERATURE_KEY);
        String descricaoClima = extrairInformacao(resposta, DESCRIPTION_KEY);
        String umidade = extrairInformacao(resposta, HUMIDITY_KEY);
        String pressao = extrairInformacao(resposta, PRESSURE_KEY);

        return "Clima em " + cidade + ": Temperatura atual: " + temperatura + "°C, Condições: " + descricaoClima +
                ", Umidade: " + umidade + "%, Pressão: " + pressao + "hPa";
    }

    private String extrairInformacao(String resposta, String chave) {
        return resposta.contains(chave) ? resposta.split(chave)[1].split(":")[1].split(",")[0].trim() : "N/A";
    }
}
