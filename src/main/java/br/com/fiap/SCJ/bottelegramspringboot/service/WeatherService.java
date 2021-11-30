package br.com.fiap.SCJ.bottelegramspringboot.service;

import java.io.IOException;
import java.net.URISyntaxException;

public interface WeatherService {
    String weather(String city);

    String forecast(String city);
}
