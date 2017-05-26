package clients;

import filters.Filters;

/**
 * Created by Dror Nir on 25/05/2017.
 */
public class CLIInterpreter implements Client {

    public Filters interpret(Object input) throws IllegalArgumentException {
        if (!(input instanceof String[])) {
            throw new IllegalArgumentException("Unsupported input for " + this.getClass() + ": expected String[], got " + input.getClass());
        }
        return interpretArgs((String[]) input);
    }

    public Filters interpretArgs(String[] input) {
        //TODO
        return null;
    }

    public String helpMessage() {
        //TODO
        return null;
    }
}
