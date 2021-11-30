package br.com.fiap.SCJ.bottelegramspringboot.service.impl.data.output;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.MessageFormat;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastResponse {

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String date;

    @JsonProperty("description")
    private String descriptionCondition;

    @JsonProperty("city")
    private String city;

    @JsonProperty("weekday")
    private String weekday;

    @JsonProperty("max")
    private Integer max;

    @JsonProperty("min")
    private Integer min;

    @JsonProperty("condition")
    private String condition;

    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("Cidade: {0} \n");
        toString.append("Data: {1} \n");
        toString.append("Clima: {2} \n");

        return MessageFormat.format(toString.toString(), city, date, descriptionCondition);
    }
}