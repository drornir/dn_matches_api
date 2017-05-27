package data;

public enum StatusOption {
    UPCOMING("upcoming"),
    PLAYED("played");

    private final String str;

    StatusOption(String s) {
        this.str = s;
    }

    public String getName() {
        return str;
    }
}
