package data;

import config.Config;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public enum GameField {
    HOME_TEAM("fs.input.fieldName.homeTeam"),
    AWAY_TEAM("fs.input.fieldName.awayTeam"),
    TOURNAMENT("fs.input.fieldName.tournament"),
    START_TIME("fs.input.fieldName.startTime"),
    STATUS(null),
    //played
    HOME_SCORE("fs.input.fieldName.homeScore"),
    AWAY_SCORE("fs.input.fieldName.awayScore"),
    //upcoming
    KICKOFF("fs.input.fieldName.kickoff");

    private final String fieldNameInData;

    GameField(String propertiesKey) {
        if(propertiesKey == null){
            this.fieldNameInData = null;
        } else {
            this.fieldNameInData = Config.get().getString(propertiesKey);
        }
    }

    public String getFieldNameInData() {
        return fieldNameInData;
    }
}
