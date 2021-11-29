package br.com.fiap.SCJ.bottelegramspringboot.command.impl;

import br.com.fiap.SCJ.bottelegramspringboot.command.ChatCommand;
import org.mariuszgromada.math.mxparser.Expression;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MathParserChatCommandImpl implements ChatCommand {

    private static final String COMANDO = "calc";

    @Override
    public String comando() {
        return COMANDO;
    }

    @Override
    public String execute(Update update, String param) {

        Expression expression = new Expression(param);

        return String.format("Resultado: %.2f", expression.calculate());

    }

}
