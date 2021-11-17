package br.com.fiap.SCJ.bottelegramspringboot.logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BotMessagesLogger {

    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void logIncomingMessage(Object message) {
        log.trace("{\"message_received\": {}}", objectMapper.writeValueAsString(message));
    }

    @SneakyThrows
    public void logSendingMessage(Object message) {
        log.trace("{\"message_sent\": {}}", objectMapper.writeValueAsString(message));
    }

}
