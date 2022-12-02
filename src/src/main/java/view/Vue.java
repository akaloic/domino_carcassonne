package view;

import model.Joueur;
import model.Tuile;

public class Vue {
    protected int limiteSac;
    protected Joueur a, b;
    protected Tuile[][]plateau = new Tuile[10][10];

    public Vue() {
        a = new Joueur();
        a.setSonTour(true);
        b = new Joueur();
        limiteSac = 10;
        for (int i=0; i<plateau.length; i++){
            for (int j=0; j<plateau[i].length; j++){
                int[]x = new int[3];
                x[0]=-1;
                x[1]=-1;
                x[2]=-1;
                plateau[i][j] = new Tuile(x,x,x,x);
            }
        }
        plateau[5][5] = new Tuile();
    }

    public void add(int i, int j){

    }

    public void affichage(){
        System.out.println("Plateau :");
        for (Tuile[] t : plateau){
            for (Tuile t2 : t){
                System.out.print(t2.getUp()[0] + " " + t2.getUp()[1] + " " + t2.getUp()[2]);
                System.out.print(t2.getLeft()[0] + " " + t2.getLeft()[1] + " " + t2.getLeft()[2]);
                System.out.print(t2.getRight()[0] + " " + t2.getRight()[1] + " " + t2.getRight()[2]);
                System.out.print(t2.getDown()[0] + " " + t2.getDown()[1] + " " + t2.getDown()[2]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Vue v = new Vue();
        v.affichage();
    }
}
