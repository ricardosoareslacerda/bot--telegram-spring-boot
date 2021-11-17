package br.com.fiap.SCJ.bottelegramspringboot.service;

import br.com.fiap.SCJ.bottelegramspringboot.service.data.input.ExchangeTodayInput;
import br.com.fiap.SCJ.bottelegramspringboot.service.data.output.ExchangeTodayOutput;

public interface ExchangeService {

    ExchangeTodayOutput exchangeToday(ExchangeTodayInput input);

}
