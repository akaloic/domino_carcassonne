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

    public int taille(){ return main.list.size(); }
    public int pioche(){
        main.list.addFirst(new Tuile());
        //else -> est potentielllement une Exception
        return 1;
    }

    public Tuile Joue(){
        //if (taille()-1 < 0) Exception
        Tuile x = main.list.getFirst();
        return x;
    }

    public class Main {
        protected int max;
        protected LinkedList<Tuile> list = new LinkedList<>();

        public Main() {
            max = 5;
        }

        public LinkedList<Tuile> getList() {return list;}
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
