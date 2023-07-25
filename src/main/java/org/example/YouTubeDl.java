package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class YouTubeDl {

    private String URL;
    private static String folderPath;
    private final String exePath;
    private String commandString="";

    public static String getFolderPath() {
        return folderPath;
    }

    private final List<DlProperty> dlAudioPropertyList=new ArrayList<>();
    private final List<DlProperty> dlVideoFormatList=new ArrayList<>();
    private final List<DlProperty> dlFilesystemList=new ArrayList<>();

    public YouTubeDl(String folderPath,String exePath) {
        YouTubeDl.folderPath = folderPath;
        this.exePath=exePath;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void addAudioProperty(DlAudioProperty dlAudioProperty) {
        if (!dlAudioPropertyList.contains(dlAudioProperty)) {
            dlAudioPropertyList.add(dlAudioProperty);
        }
    }

    public void addVideoFormat(DlVideoFormat dlVideoFormat) {
        if (!dlVideoFormatList.contains(dlVideoFormat)) {
            dlVideoFormatList.add(dlVideoFormat);
        }
    }

    public void addFilesystem(DlFilesystem dlFilesystem) {
        if (!dlFilesystemList.contains(dlFilesystem)) {
            dlFilesystemList.add(dlFilesystem);
        }
    }

    public String exec() {
        String path=null;
        String target="[ffmpeg] Destination: ";

        try
        {
            commandString+=exePath+" ";

            dlVideoFormatList.forEach(dlProperty -> commandString+=
                    ((DlVideoFormat) dlProperty).toString());

            dlAudioPropertyList.forEach(dlProperty -> commandString+=
                    ((DlAudioProperty) dlProperty).toString());

            dlFilesystemList.forEach(dlProperty -> commandString+=
                    ((DlFilesystem) dlProperty).toString());

            commandString+=URL;

            ProcessBuilder pb=new ProcessBuilder("cmd.exe","/c", commandString);
            pb.redirectErrorStream(true);
            Process process=pb.start();
            BufferedReader inStreamReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), "CP1251"));
            String line;
            while((line = inStreamReader.readLine()) != null)
            {
                System.out.println(line);
                if (line.contains(target)) {
                    path=line.replace(target,"" );
                }
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        return path;
    }
}
