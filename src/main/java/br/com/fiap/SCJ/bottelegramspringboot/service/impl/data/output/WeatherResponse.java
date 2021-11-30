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
public class WeatherResponse {

    @JsonProperty("temp")
    private Integer temp;

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private String date;

    @JsonProperty("time ")
    private String time;

    @JsonProperty("description")
    private String descriptionCondition;

    @JsonProperty("city")
    private String city;

    @JsonProperty("humidity")
    private Integer humidity;

    @JsonProperty("wind_speedy")
    private String wind_speedy;

    @JsonProperty("sunrise")
    private String sunrise;

    @JsonProperty("sunset")
    private String sunset;

    @JsonProperty("condition_slug")
    private String condition_slug;

    private enum CONDITION {
        STORM("storm", "Tempestade"),
        SNOW("snow", "Neve"),
        HAIL("hail", "Granizo"),
        RAIN("rain", "Chuva"),
        FOG("fog", "Neblina"),
        CLEAR_DAY("clear_day", "Dia limpo"),
        CLEAR_NIGHT("clear_night", "Noite limpa"),
        CLOUD("cloud", "Nublado"),
        CLOUDLY_DAY("cloudly_day", "Nublado de dia"),
        CLOUDLY_NIGHT("cloudly_night", "Nublado de noite");

        private String condition;
        public String getCondition() {
            return condition;
        }

        private String description;
        public String getDescription() {
            return description;
        }

        CONDITION(String condition, String description) {
            this.condition = condition;
            this.description = description;
        }

        public static String from (final String entryCondition) {
            for (CONDITION condition : CONDITION.values()) {
                if (condition.getCondition().equalsIgnoreCase(entryCondition))
                    return condition.getDescription();
            }
            return "";
        }
    }

    public String toString() {
        StringBuilder toString = new StringBuilder();
        toString.append("Cidade: {0} \n");
        toString.append("Data: {1} \n");
        toString.append("Temperatura: {2}º C \n");
        toString.append("Clima: {3} \n");
        toString.append("Umidade atual: {4, number}% \n");
        toString.append("Velocidade do vento em: {5} \n");
        toString.append("Nascer do sol: {6} \n");
        toString.append("Pôr do sol: {7} \n");
        toString.append("Tempo atual: {8} \n");

        return MessageFormat.format(toString.toString(), city, date, temp, descriptionCondition, humidity, wind_speedy, sunrise, sunset, CONDITION.from(condition_slug));
    }
}