package org.example;

public enum AudioProperty {

    EXTRACT_AUDIO("--extract-audio"),
    AUDIO_FORMAT("--audio-format");

    private final String title;

    AudioProperty(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
