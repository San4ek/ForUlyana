package org.example;

public record DlVideoFormat(VideoFormatOptions videoFormatOptions,
                            VideoFormatValue videoFormatValue) implements DlProperty {

    @Override
    public String toString() {
        return videoFormatOptions.getFormat()+" "+videoFormatValue.getCode()+" ";
    }
}
