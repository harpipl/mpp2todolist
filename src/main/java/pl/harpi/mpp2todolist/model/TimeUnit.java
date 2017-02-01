package pl.harpi.mpp2todolist.model;

public enum TimeUnit {
    MINUTES("I"),
    HOURS("H"),
    DAYS("D"),
    WEEKS("W"),
    MONTHS("M"),
    YEARS("Y"),
    UNKNOWN("");

    private String symbol;

    private TimeUnit(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static TimeUnit fromMpp(net.sf.mpxj.TimeUnit units) {
        switch (units) {
            case MINUTES:
                return MINUTES;
            case HOURS:
                return HOURS;
            case DAYS:
                return DAYS;
            case WEEKS:
                return WEEKS;
            case MONTHS:
                return MONTHS;
            case YEARS:
                return YEARS;
            default:
                return UNKNOWN;
        }
    }
}
