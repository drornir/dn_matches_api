package io;

import config.Config;
import data.*;

import java.util.Map;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public class PlayedGames extends FileSystemGamesResource implements GamesResource {
    public PlayedGames() {
        inputFormat = Config.get().getString("fs.input.format.played");
        filename = Config.get().getString("fs.input.filename.played");
    }


    @Override
    Game convertRowToGame(Map<String, String> row) {
        Game game = new KeyValueGame(row);
        game.add(GameField.STATUS,new GameValue(StatusOptions.PLAYED));
        return game;
    }
}
