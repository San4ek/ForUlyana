package org.example;

public enum AudioPropertyValue {

    MP3("mp3"),
    AAC("aac"),
    flac("flac"),
    M4A("m4a"),
    OPUS("opus"),
    VORBIS("vorbis"),
    WAV("wav"),
    BESTAUDIO("bestaudio"),
    BESTVIDEO("bestvideo"),
    NO("");


    private final String title;

    AudioPropertyValue(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
