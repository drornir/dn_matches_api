package io.output;

import java.io.OutputStream;

/**
 * Created by Dror Nir on 27/05/2017.
 */
public enum OutputStreamPreset {
    STANDARD("stdout", System.out);

    private final String name;

    private final OutputStream outputStream;

    OutputStreamPreset(String name, OutputStream outputStream) {
        this.name = name;
        this.outputStream = outputStream;
    }

    public String getName() {
        return name;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }
}
