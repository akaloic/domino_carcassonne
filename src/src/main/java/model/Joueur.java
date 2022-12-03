package model;

import java.util.LinkedList;

public class Joueur {
    protected int id;
    private static int n = 0;
    private int point;
    protected Main main;

    protected boolean tour;

    public Joueur() {
        id = n++;
        tour = false;
        main = new Main();
        point = 0;
    }

    public class Main {
        protected int max;
        protected LinkedList<Tuile> list = new LinkedList<>();

        public Main() {
            max = 5;
        }
        public int taille(){ return list.size(); }
        public void pioche(){
            if (taille() < max) list.add(new Tuile());
            //else -> est potentielllement une Exception
        }

        public void AJouer(){
            //if (taille()-1 < 0) Exception
            list.removeLast();
        }
    }

    //void pioche(){ main.add(new Tuile()); }

    // ----getter et setter----
    public int getId() {
        return id;
    }
    public boolean sonTour() {
        return tour;
    }

    public Main getMain() { return main; }

    public void setSonTour(boolean tour) {
        this.tour = tour;
    }
    // ----getter et setter----
}
