package io.input;

import config.Config;
import data.*;

import java.util.Map;


public class UpcomingGames extends FileSystemGamesResource implements GamesResource {
    public UpcomingGames() {
        inputFormat = Config.get().getString("input.fs.format.upcoming");
        filename = Config.get().getString("input.fs.filename.upcoming");
    }

    @Override
    Game convertRowToGame(Map<String, String> row) {
        Game game = new KeyValueGame(row);
        game.add(GameField.STATUS,new GameValue(StatusOption.UPCOMING.getName()));
        return game;
    }
}
