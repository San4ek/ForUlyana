package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bot extends TelegramLongPollingBot {

    final private String BOT_TOKEN = "6038643452:AAF1wLmlzdG1fkr29HAlI20aymgOCU8aWHs";
    final private String BOT_NAME = "MusicBot";

    @Override
    public String getBotUsername() {
        return BOT_NAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        try{
            if(update.hasMessage() && update.getMessage().hasText())
            {
                Message inMess = update.getMessage();

                String chatId = inMess.getChatId().toString();

                System.out.println(inMess.getText());

                SendAudio sendAudio=new SendAudio(chatId, parseMessage(inMess.getText()));

                execute(sendAudio);
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    public InputFile parseMessage(String textMsg) {
        String path = null;
        try
        {
            Process p=Runtime.getRuntime().exec("C:\\YouTubeDl\\youtube-dl.exe -f 251 --audio-format mp3 --output \""+textMsg+".mp3\" "+textMsg);
            BufferedReader reader=new BufferedReader(
                    new InputStreamReader(p.getInputStream())
            );
            String line;
            while((line = reader.readLine()) != null)
            {
                System.out.println(line);
                if (line.contains("Destination: ")) {
                    path=line.substring(24);
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        InputFile inputFile=null;

        if (path!=null) {
            inputFile = new InputFile(new File("C:\\Users\\iNQU1SITOR\\IdeaProjects\\ForUlyana\\" + path));
        }

        return inputFile;
    }
}