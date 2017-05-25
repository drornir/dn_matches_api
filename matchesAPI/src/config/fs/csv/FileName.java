package config.fs.csv;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public enum FileName {
    UPCOMING ("result_upcoming.csv"),
    PLAYED ("result_played.csv");

    private final String name;

    FileName(String s) {
        this.name = s;
    }

    public String getName(){
        return this.name;
    }
}
