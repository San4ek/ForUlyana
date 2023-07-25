package org.example;

public enum VideoFormatValue {
    BESTAUDIO("bestaudio"),
    BESTVIDEO("bestvideo");

    private final String code;

    VideoFormatValue(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
