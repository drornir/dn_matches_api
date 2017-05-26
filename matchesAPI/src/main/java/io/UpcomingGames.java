package io;

import config.Config;
import data.Game;

import java.util.Iterator;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public class UpcomingGames extends FileSystemGamesResource implements GamesResource {
    public UpcomingGames() {
        filename = Config.get().getString("fs.input.upcoming");
    }
    @Override
    public Iterator<Game> getGames() {
        return null;
    }
}
