package quanlytranxephang.entities;

import java.time.LocalDateTime;
import java.util.List;

public class SommonRift {
    private List<Name>names;
    private List<Figure>figures;
    private String time;

    public SommonRift(List<Figure> figures, String time, List<Name> names) {
        this.figures = figures;
        this.time = time;
        this.names = names;
    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<Figure> getFigures() {
        return figures;
    }

    public void setFigures(List<Figure> figures) {
        this.figures = figures;
    }

    @Override
    public String toString() {
        return "SommonRift{" +
                "names=" + names +
                ", figures=" + figures +
                ", time='" + time + '\'' +
                '}';
    }
}
