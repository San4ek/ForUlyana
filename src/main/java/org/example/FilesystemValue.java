package org.example;

public enum FilesystemValue {

    TITLE("\""+YouTubeDl.getFolderPath()+"%(title)s.%(ext)s\""),
    NO("");

    private final String template;

    FilesystemValue(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
