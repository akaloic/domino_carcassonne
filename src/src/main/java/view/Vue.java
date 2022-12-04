package view;

import model.Joueur;
import model.Tuile;

public class Vue {
    protected int limiteSac;
    protected Joueur a, b;
    protected Tuile[][]plateau = new Tuile[10][10];
    protected int scoreA, scoreB;
    protected boolean tour;

    public Vue() {
        a = new Joueur();
        a.setSonTour(true);
        b = new Joueur();

        tour = true;
        limiteSac = 10;

        plateau[5][5] = new Tuile();
        scoreA = 0;
        scoreB = 0;
    }
    public void add(int x, int y){
        if (estNull(x,y)){
            boolean ok = tour;
            tour = !tour;
            if (ok) plateau[x][y] = a.Joue();
            else plateau[x][y] = b.Joue();
            //test si la tuile a des voisins
            if (!estDehors(x-1, y)) {
                if(!estNull(x-1,y)){
                    plateau[x - 1][y].setExistUp(true);
                    plateau[x][y].setExistDown(true);
                    calculScore(x,y,ok,"up");
                }
            }
            if (!estDehors(x+1, y)) {
                if(!estNull(x+1,y)){
                    plateau[x + 1][y].setExistDown(true);
                    plateau[x][y].setExistUp(true);
                    calculScore(x,y,ok,"down");
                }
            }
            if (!estDehors(x, y-1)) {
                if(!estNull(x,y-1)){
                    plateau[x][y - 1].setExistRight(true);
                    plateau[x][y].setExistLeft(true);
                    calculScore(x,y,ok,"right");
                }
            }
            if (!estDehors(x, y+1)) {
                if(!estNull(x,y+1)){
                    plateau[x][y + 1].setExistLeft(true);
                    plateau[x][y].setExistRight(true);
                    calculScore(x,y,ok,"left");
                }
            }
        }else{
            System.out.print("La case est déjà prise.");
        }
    }
    public void calculScore(int i, int j, boolean joueur, String direction){
        Tuile t = plateau[i][j];
        switch (direction) {
            case "up":
                if (plateau[i - 1][j].getDown()[0] == t.getUp()[0] && plateau[i - 1][j].getDown()[1] == t.getUp()[1] && plateau[i - 1][j].getDown()[2] == t.getUp()[2]) {
                    int score = t.getUp()[0] + t.getUp()[1] + t.getUp()[2];
                    if (joueur) scoreA += score;
                    else scoreB += score;
                }
                break;
            case "down":
                if (plateau[i + 1][j].getUp()[0] == t.getDown()[0] && plateau[i + 1][j].getUp()[1] == t.getDown()[1] && plateau[i + 1][j].getUp()[2] == t.getDown()[2]) {
                    int score = t.getDown()[0] + t.getDown()[1] + t.getDown()[2];
                    if (joueur) scoreA += score;
                    else scoreB += score;
                }
                break;
            case "right":
                if (plateau[i][j - 1].getRight()[0] == t.getLeft()[0] && plateau[i][j - 1].getRight()[1] == t.getLeft()[1] && plateau[i][j - 1].getRight()[2] == t.getLeft()[2]) {
                    int score = t.getLeft()[0] + t.getLeft()[1] + t.getLeft()[2];
                    if (joueur) scoreA += score;
                    else scoreB += score;
                }
                break;
            case "left":
                if (plateau[i][j+1].getLeft()[0] == t.getRight()[0] && plateau[i][j+1].getLeft()[1] == t.getRight()[1] && plateau[i][j+1].getLeft()[2] == t.getRight()[2]){
                    int score = t.getRight()[0] + t.getRight()[1] + t.getRight()[2];
                    if (joueur) scoreA += score;
                    else scoreB += score;
                }
                break;
        }
    }


    private boolean estDehors(int i, int j){ return (i < 0 || i > 9 || j < 0 || j > 9); }
    private boolean estNull(int i, int j){ return plateau[i][j]== null; }

    public void affichage(){
        System.out.println("Joueur "+a.getId()+" : "+a.taille()+" tuiles");
        System.out.println("Joueur "+b.getId()+" : "+b.taille()+" tuiles");
        System.out.println("Tuiles restantes : "+limiteSac);
        System.out.println("Score : "+scoreA+" - "+scoreB);
        System.out.println("Tour du joueur "+(tour ? a.getId() : b.getId()));
        System.out.println("Plateau :");

        System.out.println();
        System.out.print("    ");
        System.out.print("|");
        for (int i=0; i<10; i++) System.out.print("| "+i+" |");
        System.out.print("|");
        System.out.println('\n');
        for (int i=0; i<10; i++){
            System.out.print("|"+i+"|"+'\n');
            String[] x = new String[5];
            for (int k=0; k<5; k++) x[k] = "     ";
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
        v.limiteSac -= v.a.pioche();
        v.limiteSac -= v.b.pioche();
        v.add(5,4);
        v.add(5,6);
        v.add(4,5);
        v.add(6,5);
        v.affichage();
    }
}
