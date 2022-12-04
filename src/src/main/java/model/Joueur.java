package model;

import java.util.LinkedList;
import java.util.Stack;

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
    public void pioche(){
        main.list.add(new Tuile());
        //else -> est potentielllement une Exception
    }

    public Tuile tuile(){
        return main.list.peek();
    }

    public class Main {
        protected int max;
        protected Stack<Tuile> list = new Stack<>();

        public Main() {
            max = 5;
        }

        public void add(Tuile t) {
            if (list.size() < max) list.add(t);
            //else -> est potentielllement une Exception
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
