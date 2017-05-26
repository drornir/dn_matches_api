package io;

import config.Config;
import data.Game;

import java.util.Iterator;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public class PlayedGames extends FileSystemGamesResource implements GamesResource {
    public PlayedGames() {
        filename = Config.get().getString("fs.input.played");
    }

    @Override
    public Iterator<Game> getGames() {
        return null;
    }
}
