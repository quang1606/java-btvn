package quanlytranxephang.entities;

import java.time.LocalDateTime;
import java.util.List;

public class SommonRift {
    private List<Name>names;
    private List<Figure>figures;


    public SommonRift(List<Name> names, List<Figure> figures) {
        this.names = names;
        this.figures = figures;

    }

    public List<Name> getNames() {
        return names;
    }

    public void setNames(List<Name> names) {
        this.names = names;
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
                '}';
    }
}
