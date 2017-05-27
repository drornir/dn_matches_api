import clients.CLIInterpreter;
import clients.Client;
import data.Game;
import io.output.ConvertToFormat;
import io.output.OutputWriter;
import query.QueryEngine;
import query.filters.Filters;

import java.util.Iterator;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args){
        Client client = new CLIInterpreter();
        Filters filters = client.interpret(args);
        if(filters == null){
            exit(0);
        }
        Iterator<Game> games = null;
        try {
            games = QueryEngine.getInstance().query(filters);
        } catch (Exception e) {
            System.err.print("Error in QueryEngine.query");
            e.printStackTrace();
            exit(1);
        }
        assert games != null;
        OutputWriter.getInstance().write(ConvertToFormat.getInstance().convert(games));
    }
}
