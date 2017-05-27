package data;

/**
 * Created by Dror Nir on 27/05/2017.
 */
public class Tournament extends FootballEntity{
    public Tournament(String name) {
        super(name);
        id = IdFactory.getInstance().getAndIncrement(Tournament.class);
    }
}
