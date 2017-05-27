package data;

import java.util.Map;


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

    private Team handleTeam(String valueString) {
        Map<String, Object> map = ClassPoolProvider.getInstance().get(Team.class);
        Team team = (Team) map.get(valueString);
        if (team == null) {
            team = new Team(valueString);
            map.put(valueString, team);
        }
        return team;
    }

    private Tournament handleTournament(String valueString) {
        Map<String, Object> map = ClassPoolProvider.getInstance().get(Team.class);
        Tournament tournament = (Tournament) map.get(valueString);
        if (tournament == null) {
            tournament = new Tournament(valueString);
            map.put(valueString, tournament);
        }
        return tournament;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameValue gameValue = (GameValue) o;

        return value != null ? value.equals(gameValue.value) : gameValue.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
