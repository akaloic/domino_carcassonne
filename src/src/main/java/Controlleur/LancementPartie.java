package Controlleur;

import model.Tuile;
import view.Vue;

import java.util.Scanner;

public class LancementPartie{
    protected Scanner scanner;
    protected Vue vue;

    public LancementPartie() {
        scanner = new Scanner(System.in);
        vue = new Vue();
        vue.affichage();
    }

    public boolean demandeLancement(){
        System.out.println("Voulez-vous lancer une partie ? (oui/non)");
        String reponse = scanner.nextLine();
        if (reponse.equals("oui")){
            return true;
        }
        else if (reponse.equals("non")){
            return false;
        }
        else{
            System.out.println("Veuillez répondre par oui ou non.");
            return demandeLancement();
        }
    }

    public void choixJoeur(){
        System.out.println("Vous voulez piocher ou abandonner ? (p = piocher/a = abandonner).");
        String reponse = scanner.nextLine();
        if (reponse.equals("p")) vue.pioche();
        else if (reponse.equals("a")){
            System.out.println("Vous avez abandonné.");
            vue.affichage();
            System.out.println("Fin de la partie");
            System.out.println("Score A : "+vue.getScoreA());
            System.out.println("Score B : "+vue.getScoreB());
            System.exit(0);
        }
        else{
            System.out.println("Veuillez répondre par 'p' ou 'a'.");
            choixJoeur();
        }
    }

    public void demandePlacement(){
        int[] placement = new int[2];
        String x = vue.getTour() ? "A" : "B";
        System.out.println("Joueur"+x+", veuillez entrer les coordonnées de la tuile entre 0 et 9.");
        System.out.print("x : ");
        placement[0] = scanner.nextInt();
        System.out.print("y : ");
        placement[1] = scanner.nextInt();
        vue.add(placement[0],placement[1]);
        vue.affichage();
    }

    private void montreTuile(){
        if (vue.getTour()) vue.getA().tuile().affiche();
        else vue.getB().tuile().affiche();
    }

    private void demandeRotation(){
        String x = vue.getTour() ? "A" : "B";
        System.out.println("Joueur"+x+", voulez-vous pivoter(= dans sens aiguille d'une montre) votre tuile ? (oui/non)");
        String reponse = scanner.nextLine();
        if (reponse.equals("oui")){
            if (vue.getTour()){
                vue.getA().tuile().rotation();
                vue.getA().tuile().affiche();
            } else {
                vue.getB().tuile().rotation();
                vue.getB().tuile().affiche();
            }
            boolean fin = false;
            while (!fin){
                System.out.println("Voulez-vous encore pivoter votre tuile ? (oui/non)");
                reponse = scanner.nextLine();
                switch (reponse){
                    case "oui":
                        if (vue.getTour()){
                            vue.getA().tuile().rotation();
                            vue.getA().tuile().affiche();
                        } else {
                            vue.getB().tuile().rotation();
                            vue.getB().tuile().affiche();
                        }
                        break;
                    case "non":
                        fin = true;
                        break;
                    default:
                        System.out.println("Veuillez répondre par oui ou non.");
                }
            }
        }
        else if (reponse.equals("non")){

        }
        else{
            System.out.println("Veuillez répondre par oui ou non.");
            demandeRotation();
        }
    }

    public void lancement(){
        while (vue.getLimiteSac() > 0){
            if (vue.getTour()) System.out.println("Joueur A, c'est votre tour.");
            else System.out.println("Joueur B, c'est votre tour.");
            choixJoeur();
            System.out.println("Voici la tuile que vous avez pioché :");
            montreTuile();
            demandeRotation();
            demandePlacement();
        }
        System.out.println("Fin de la partie");
        System.out.println("Score A : "+vue.getScoreA());
        System.out.println("Score B : "+vue.getScoreB());
    }

    public static void main(String[] args) {
        LancementPartie lancementPartie = new LancementPartie();
        if (lancementPartie.demandeLancement()){
            lancementPartie.lancement();
        }
    }
}
