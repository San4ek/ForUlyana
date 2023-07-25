package org.example;

public record DlAudioProperty(AudioProperty audioProperty,
                              AudioPropertyValue audioPropertyValue) implements DlProperty {

    @Override
    public String toString() {
        return audioProperty.getTitle()+" "+audioPropertyValue.getTitle()+" ";
    }
}
