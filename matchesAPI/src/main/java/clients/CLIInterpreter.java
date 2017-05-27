package clients;

import data.GameField;
import data.GameValue;
import query.filters.Filters;
import org.apache.commons.cli.*;
import query.filters.operators.And;
import query.filters.operators.Equality;
import query.filters.operators.Or;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class CLIInterpreter implements Client {
    final Options options;

    public CLIInterpreter() {
        options = new Options();

        options.addOption("h", "help", false, "Print this message");

        options.addOption(Option.builder("b")
                .longOpt("by")
                .hasArg()
                .argName("TYPE")
                .required(true)
                .type(String.class)
                .desc("Get matches by TYPE. TYPE can be \"team\" or \"tournament\"")
                .build()
        );

        options.addOption(Option.builder("n")
                .longOpt("name")
                .hasArg()
                .argName("NAME")
                .required(true)
                .type(String.class)
                .desc("The name of the team or tournament")
                .build()
        );

        options.addOption(Option.builder("s")
                .longOpt("status")
                .hasArg()
                .argName("STATUS")
                .required(false)
                .type(String.class)
                .desc("Filter by match status. STATUS can be \"played\" or \"upcoming\"")
                .build()
        );
    }

    public Filters interpret(Object input) throws IllegalArgumentException {
        if (!(input instanceof String[])) {
            throw new IllegalArgumentException("Unsupported input for " + this.getClass() + ": expected String[], got " + input.getClass());
        }
        try {
            return interpretArgs((String[]) input);
        } catch (ParseException e) {
            throw new IllegalArgumentException("CLI interpreter parsing exception: ", e);
        }
    }

    public Filters interpretArgs(String[] args) throws ParseException {
        CommandLine cmd = new DefaultParser().parse(this.options, args);
        if (cmd.hasOption("h")) {
            printHelp();
            return null;
        }
        if (!cmd.hasOption("b") || !cmd.hasOption("n")) {
            throw new IllegalArgumentException("Must provide \"by\" and \"name\"");
        }
        String by = cmd.getOptionValue("b");
        Filters entityFilters;
        if (by.equals("team")) {
            entityFilters = buildTeamFilters(cmd.getOptionValue("n"));
        } else if (by.equals("tournament")) {
            entityFilters = buildTournamentFilters(cmd.getOptionValue("n"));
        } else {
            throw new IllegalArgumentException("\"by\" must be team or tournament");
        }
        if(!cmd.hasOption("s")){
            return entityFilters;
        } else{
            String status = cmd.getOptionValue("s");
            if(!(status.equals("played") || status.equals("upcoming"))){
                throw new IllegalArgumentException("\"status\" must be played or upcoming");
            }
            Equality statusFilter = new Equality(GameField.STATUS,new GameValue(GameField.STATUS,status));
            List<Filters> andFilterList = new ArrayList<>();
            andFilterList.add(entityFilters);
            andFilterList.add(statusFilter);
            return new And(andFilterList);
        }
    }

    private Filters buildTeamFilters(String teamName) {
        Equality home = new Equality(GameField.HOME_TEAM, new GameValue(GameField.HOME_TEAM, teamName));
        Equality away = new Equality(GameField.AWAY_TEAM, new GameValue(GameField.AWAY_TEAM, teamName));
        List<Filters> filtersList = new ArrayList<>();
        filtersList.add(home);
        filtersList.add(away);
        return new Or(filtersList);
    }

    private Filters buildTournamentFilters(String tourName) {
        return new Equality(GameField.TOURNAMENT, new GameValue(GameField.TOURNAMENT, tourName));
    }

    public void printHelp() {
        new HelpFormatter().printHelp("", this.options);
    }
}
