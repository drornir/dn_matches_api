package io.input;

import config.Config;
import data.*;

import java.util.Map;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public class UpcomingGames extends FileSystemGamesResource implements GamesResource {
    public UpcomingGames() {
        inputFormat = Config.get().getString("input.fs.format.upcoming");
        filename = Config.get().getString("input.fs.filename.upcoming");
    }

    @Override
    Game convertRowToGame(Map<String, String> row) {
        Game game = new KeyValueGame(row);
        game.add(GameField.STATUS,new GameValue(StatusOption.UPCOMING));
        return game;
    }
}
