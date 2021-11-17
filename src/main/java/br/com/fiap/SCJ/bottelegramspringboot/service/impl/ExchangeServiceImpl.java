package br.com.fiap.SCJ.bottelegramspringboot.service.impl;

import br.com.fiap.SCJ.bottelegramspringboot.config.property.ExchangeServiceProperties;
import br.com.fiap.SCJ.bottelegramspringboot.service.ExchangeService;
import br.com.fiap.SCJ.bottelegramspringboot.service.data.input.ExchangeTodayInput;
import br.com.fiap.SCJ.bottelegramspringboot.service.data.output.ExchangeTodayOutput;
import br.com.fiap.SCJ.bottelegramspringboot.service.impl.data.output.ExchangeTodayResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService {

    private final RestTemplate restTemplate;
    private final ExchangeServiceProperties properties;

    @Override
    public ExchangeTodayOutput exchangeToday(ExchangeTodayInput input) {

        String coinCodeFrom = Optional.ofNullable(input)
                .map(ExchangeTodayInput::getCoinCodeFrom)
                .orElseGet(properties::getDefaultCoinCodeFrom);

        String coinCodeTo = Optional.ofNullable(input)
                .map(ExchangeTodayInput::getCoinCodeTo)
                .orElseGet(properties::getDefaultCoinCodeTo);

        ResponseEntity<Map<String, ExchangeTodayResponse>> responseEntity = restTemplate.exchange(
                properties.getUrlExchangeToday(),
                HttpMethod.GET,
                new HttpEntity<>(new HttpHeaders()),
                new ParameterizedTypeReference<>() {
                },
                coinCodeFrom,
                coinCodeTo
        );

        return Optional.of(responseEntity)
                .map(HttpEntity::getBody)
                .map(Map::values)
                .map(Collection::stream)
                .map(it -> it.map(ExchangeTodayResponse::getAsk))
                .flatMap(Stream::findFirst)
                .map(ExchangeTodayOutput::new)
                .orElseThrow(RuntimeException::new);

    }

}
