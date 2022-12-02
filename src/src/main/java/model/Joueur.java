package model;

import java.util.LinkedList;

public class Joueur {
    protected int id;
    private static int n = 0;
    protected boolean tour;
    protected LinkedList<Tuile> main = new LinkedList<>();

    public Joueur() {
        id = n++;
        tour = false;
    }

    void pioche(){ main.add(new Tuile()); }

    // ----getter et setter----
    public int getId() {
        return id;
    }
    public boolean sonTour() {
        return tour;
    }
    public LinkedList<Tuile> getMain() {
        return main;
    }

    public void setSonTour(boolean tour) {
        this.tour = tour;
    }
    // ----getter et setter----
}
