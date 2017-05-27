package data;

import config.Config;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public enum GameField {
    HOME_TEAM("input.fs.fieldName.homeTeam"),
    AWAY_TEAM("input.fs.fieldName.awayTeam"),
    TOURNAMENT("input.fs.fieldName.tournament"),
    START_TIME("input.fs.fieldName.startTime"),
    STATUS(null),
    //played
    HOME_SCORE("input.fs.fieldName.homeScore"),
    AWAY_SCORE("input.fs.fieldName.awayScore"),
    //upcoming
    KICKOFF("input.fs.fieldName.kickoff");

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
