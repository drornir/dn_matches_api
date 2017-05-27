package io.output;

import config.Config;

import java.io.OutputStream;
import java.io.PrintWriter;


public class OutputWriter {
    private static OutputWriter ourInstance = new OutputWriter();
    private final OutputStream defaultOutputStream;

    public static OutputWriter getInstance() {
        return ourInstance;
    }

    private OutputWriter() {
        String defaultOutputSetting = Config.get().getString("output.fs.stream.default");
        OutputStream outputStream = null;
        for (OutputStreamPreset preset : OutputStreamPreset.values()) {
            if (preset.getName().equals(defaultOutputSetting)) {
                outputStream = preset.getOutputStream();
                break;
            }
        }
        this.defaultOutputStream = outputStream;
    }

    public void write(String outputString){
        write(outputString,this.defaultOutputStream);
    }
    public void write(String outputString, OutputStream outputStream){
        assert outputStream != null;
        PrintWriter writer = new PrintWriter(outputStream);
        writer.write(outputString);
        writer.flush();
    }
}
