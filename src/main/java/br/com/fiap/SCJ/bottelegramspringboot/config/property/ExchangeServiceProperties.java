package br.com.fiap.SCJ.bottelegramspringboot.config.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Validated
@ConfigurationProperties("service.exchange")
public class ExchangeServiceProperties {

    @NotBlank(message = "O atributo 'service.exchange.urlExchangeToday' precisa ser informado")
    private String urlExchangeToday;

    @NotBlank(message = "O atributo 'service.exchange.defaultCoinCodeFrom' precisa ser informado")
    private String defaultCoinCodeFrom;

    @NotBlank(message = "O atributo 'service.exchange.defaultCoinCodeTo' precisa ser informado")
    private String defaultCoinCodeTo;

}
