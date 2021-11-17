package br.com.fiap.SCJ.bottelegramspringboot.service.data.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeTodayOutput {

    private BigDecimal value;

}
