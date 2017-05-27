package io.output;

import config.Config;
import data.*;
import io.FileFormat;

import javax.json.*;
import java.util.*;


public class ConvertToFormat {
    private static ConvertToFormat ourInstance = new ConvertToFormat();
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
        Game[] gamesArray = gamesList.toArray(new Game[0]);
        return convert(gamesArray,format);
    }
    public String convert(Game[] games, FileFormat format) {
        switch (format) {
            case JSON:
                return toJson(games).toString();
            default:
                throw new Error("Unsupported format " + format);
        }
    }

    private JsonArray toJson(Game[] games) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        for (Game game : games) {
            JsonObject gameJson = toJson(game);
            builder.add(gameJson);
        }
        return builder.build();
    }

    private JsonObject toJson(Game game) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        for (Map.Entry<GameField, GameValue> dataEntry : game.getAll()) {
            GameField field = dataEntry.getKey();
            Object value = dataEntry.getValue().getValue();
            if (field.equals(GameField.STATUS)) {
                builder.add("status",(String) value);
            } else if (field.equals(GameField.HOME_TEAM) || field.equals(GameField.AWAY_TEAM) || field.equals(GameField.TOURNAMENT)) {
                FootballEntity footballEntity = (FootballEntity) value;
                builder.add(field.getFieldNameInData(),toJson(footballEntity));
            } else {
                builder.add(field.getFieldNameInData(),(String) value);
            }
        }
        return builder.build();
    }

    private JsonObject toJson(FootballEntity footballEntity) {
        JsonObjectBuilder builder = Json.createObjectBuilder();
        String name = footballEntity.getName();
        int id = footballEntity.getId();
        builder.add("name", name);
        builder.add("id", id);
        return builder.build();
    }


}
