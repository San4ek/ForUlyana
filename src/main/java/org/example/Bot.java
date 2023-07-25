package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

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

                InputFile inputFile=parseMessage(inMess.getText());

                if (inputFile!=null) {
                    SendAudio sendAudio=new SendAudio(chatId, inputFile);

                    execute(sendAudio);

                    inputFile.getNewMediaFile().delete();

                } else {
                    execute(new SendMessage(chatId,"Incorrect link"));
                }
            }
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public InputFile parseMessage(String textMsg) {

        YouTubeDl youTubeDl=new YouTubeDl("C:\\YouTubeDl\\Music\\", "C:\\YouTubeDl\\youtube-dl.exe");
        youTubeDl.setURL(textMsg);
        youTubeDl.addAudioProperty(new DlAudioProperty(AudioProperty.EXTRACT_AUDIO,AudioPropertyValue.NO));
        youTubeDl.addVideoFormat(new DlVideoFormat(VideoFormatOptions.FORMAT, VideoFormatValue.BESTAUDIO));
        youTubeDl.addAudioProperty(new DlAudioProperty(AudioProperty.AUDIO_FORMAT,AudioPropertyValue.MP3));
        youTubeDl.addFilesystem(new DlFilesystem(FilesystemOptions.OUTPUT, FilesystemValue.TITLE));
        String path=youTubeDl.exec();

        if (path!=null) {
            return new InputFile(new File(path));
        }

        return null;
    }
}