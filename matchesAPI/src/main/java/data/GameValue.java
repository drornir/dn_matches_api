package data;

import java.util.Map;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class GameValue {
    final private Object value;

    public GameValue(Object value) {
        this.value = value;
    }

    public GameValue(GameField field, String valueString) {
        assert valueString != null;
        switch (field) {
            case HOME_TEAM:
                value = handleTeam(valueString);
                break;
            case AWAY_TEAM:
                value = handleTeam(valueString);
                break;
            case TOURNAMENT:
                value = handleTournament(valueString);
                break;
            default:
                value = defaultHandler(valueString);
        }
    }

    private String defaultHandler(String valueString) {
        return valueString;
    }

    private Team handleTeam(String valueString){
        Map<String, Object> map = ClassPoolProvider.getInstance().get(Team.class);
        Team team = (Team) map.get(valueString);
        if(team == null){
            team = new Team(valueString);
            map.put(valueString,team);
        }
        return team;
    }
    private Tournament handleTournament(String valueString){
        Map<String, Object> map = ClassPoolProvider.getInstance().get(Team.class);
        Tournament tournament = (Tournament) map.get(valueString);
        if(tournament == null){
            tournament = new Tournament(valueString);
            map.put(valueString,tournament);
        }
        return tournament;
    }
}
