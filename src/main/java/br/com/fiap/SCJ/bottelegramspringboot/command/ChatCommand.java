package br.com.fiap.SCJ.bottelegramspringboot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface ChatCommand {

    String comando();

    String execute(Update update);

}
