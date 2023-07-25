package org.example;

public record DlFilesystem(FilesystemOptions filesystemOptions,
                           FilesystemValue filesystemValue) implements DlProperty {

    @Override
    public String toString() {
        return filesystemOptions.getTitle()+" "+filesystemValue.getTemplate()+" ";
    }
}
