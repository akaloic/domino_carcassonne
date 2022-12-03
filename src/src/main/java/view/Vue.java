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
        plateau[5][5] = new Tuile();
    }
    public void add(int x, int y){
        plateau[x][y] = new Tuile();
    }
    private boolean estNull(int i, int j){ return plateau[i][j]== null; }

    public void affichage(){
        for (int i=0; i<10; i++){
            String[] x = new String[5];
            for (int k=0; k<5; k++) x[k] = "";
            for (int j=0; j<10; j++){
                if (estNull(i,j)) {
                    x[0] += "     ";
                    x[1] += "     ";
                    x[2] += "     ";
                    x[3] += "     ";
                    x[4] += "     ";
                } else {
                    x[0] += " " + plateau[i][j].getUp()[0] + plateau[i][j].getUp()[1] + plateau[i][j].getUp()[2] + " ";
                    x[1] += plateau[i][j].getLeft()[0] + "   " + plateau[i][j].getRight()[0];
                    x[2] += plateau[i][j].getLeft()[1] + "   " + plateau[i][j].getRight()[1];
                    x[3] += plateau[i][j].getLeft()[2] + "   " + plateau[i][j].getRight()[2];
                    x[4] += " " + plateau[i][j].getDown()[0] + plateau[i][j].getDown()[1] + plateau[i][j].getDown()[2] + " ";
                }
            }
            for (int k=0; k<5; k++) System.out.println(x[k]);
        }
    }
    public static void main(String[] args) {
        Vue v = new Vue();
        v.add(5,4);
        v.add(5,6);
        v.add(4,5);
        v.add(6,5);
        v.add(4,4);
        v.affichage();
    }
}
