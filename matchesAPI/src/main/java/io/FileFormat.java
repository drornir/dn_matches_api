package io;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public enum FileFormat {
    CSV("csv"),
    JSON("json");

    public final String stringExt;

    FileFormat(String s) {
        this.stringExt = s;
    }
}
