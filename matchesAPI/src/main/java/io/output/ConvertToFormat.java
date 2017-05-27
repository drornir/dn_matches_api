package io.output;

import com.google.gson.Gson;
import config.Config;
import data.*;
import io.FileFormat;

import java.util.*;

/**
 * Created by Dror Nir on 27/05/2017.
 */
public class ConvertToFormat {
    private static ConvertToFormat ourInstance = new ConvertToFormat();
    private static Gson gson = new Gson();
    private final FileFormat defaultFormat;

    public static ConvertToFormat getInstance() {
        return ourInstance;
    }

    private ConvertToFormat() {
        String defaultOutputFormat = Config.get().getString("output.format");
        FileFormat fileFormat = null;
        for (FileFormat format : FileFormat.values()) {
            if (format.stringExt.equals(defaultOutputFormat)) {
                fileFormat = format;
                break;
            }
        }
        this.defaultFormat = fileFormat;
    }

    public String convert(Game[] games) {
        return convert(games, this.defaultFormat);
    }
    public String convert(Iterator<Game> games) {
        return convert(games, this.defaultFormat);
    }

    public String convert(Iterator<Game> games, FileFormat format) {
        List<Game> gamesList = new ArrayList<>();
        while(games.hasNext()){
            gamesList.add(games.next());
        }
        return convert((Game[]) gamesList.toArray(),format);
    }
    public String convert(Game[] games, FileFormat format) {
        switch (format) {
            case JSON:
                return toJson(games);
            default:
                throw new Error("Unsupported format " + format);
        }
    }

    private String toJson(Game[] games) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < games.length; i++) {
            Game game = games[i];
            String gameOut = toJson(game);
            result.add(gameOut);
        }
        return gson.toJson(result);
    }

    private String toJson(Game game) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<GameField, GameValue> dataEntry : game.getAll()) {
            GameField field = dataEntry.getKey();
            Object value = dataEntry.getValue().getValue();
            String fieldOut, valueOut;
            if (field.equals(GameField.STATUS)) {
                fieldOut = "status";//TODO generify
                valueOut = (String) value;
            } else if (field.equals(GameField.HOME_TEAM) || field.equals(GameField.AWAY_TEAM) || field.equals(GameField.TOURNAMENT)) {
                FootballEntity footballEntity = (FootballEntity) value;
                fieldOut = field.getFieldNameInData();
                valueOut = toJson(footballEntity);
//            } else if (field.equals(GameField.TOURNAMENT)) {
//                Tournament tournament = (Tournament) value;
//                fieldOut = field.getFieldNameInData();
//                valueOut = toJson(tournament);
            } else {
                fieldOut = field.getFieldNameInData();
                valueOut = (String) value;
            }
            result.put(fieldOut,valueOut);
        }
        return gson.toJson(result);
    }

    private String toJson(FootballEntity footballEntity) {
        return gson.toJson(footballEntity);
    }


}
