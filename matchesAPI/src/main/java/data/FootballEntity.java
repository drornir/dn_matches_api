package data;

/**
 * Created by Dror Nir on 27/05/2017.
 */
public abstract class FootballEntity {
    private final String name;
    int id;
    public FootballEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
