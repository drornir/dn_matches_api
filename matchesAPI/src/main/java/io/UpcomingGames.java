package io;

import config.Config;
import data.*;

import java.util.Map;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public class UpcomingGames extends FileSystemGamesResource implements GamesResource {
    public UpcomingGames() {
        inputFormat = Config.get().getString("fs.input.format.upcoming");
        filename = Config.get().getString("fs.input.filename.upcoming");
    }

    @Override
    Game convertRowToGame(Map<String, String> row) {
        Game game = new KeyValueGame(row);
        game.add(GameField.STATUS,new GameValue(StatusOptions.UPCOMING));
        return game;
    }
}
