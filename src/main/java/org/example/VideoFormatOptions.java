package org.example;

public enum VideoFormatOptions {

    FORMAT("--format");

    private final String format;

    VideoFormatOptions(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
