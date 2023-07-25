package org.example;

public enum FilesystemOptions {

    OUTPUT("--output"),
    WRITE_INFO_JSON("--write-info-json"),
    GET_FILENAME("−−get−filename"),
    PRINT_JSON("−−print−json");


    private final String title;

    FilesystemOptions(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
