package data;

/**
 * Created by Dror Nir on 27/05/2017.
 */
public class Team extends FootballEntity{

    public Team(String name) {
        super(name);
        id = IdFactory.getInstance().getAndIncrement(Team.class);
    }

}
