package pl.harpi.mpp2todolist.model;

public class Duration {
    private double duration;
    private TimeUnit units;

    public Duration(double duration, TimeUnit units) {
        this.duration = duration;
        this.units = units;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public TimeUnit getUnits() {
        return units;
    }

    public void setUnits(TimeUnit units) {
        this.units = units;
    }
}
