package model;

import java.util.Random;

public class Tuile {
    //protected static int id; a initier plus tard avec la classe joueur
    protected int[] up = new int[3];
    protected int[] down = new int[3];
    protected int[] left = new int[3];
    protected int[] right = new int[3];
    protected boolean existLeft, existRight, existUp, existDown;

    public Tuile() {
        for (int i=0; i<3; i++){
            up[i] =       new Random().nextInt(2);
            down[i] =     new Random().nextInt(2);
            left[i] =     new Random().nextInt(2);
            right[i] =    new Random().nextInt(2);
        }
        existRight = false;
        existLeft = false;
        existDown = false;
        existUp = false;
    }

    public Tuile(int[] a, int[] b, int[] c, int[] d) {
        up = a;
        down = b;
        left = c;
        right = d;
    }


    //rotation sens aiguille sens montre
    public void rotation(){
        int[] temp = new int[3];
        temp[0] = up[0];
        temp[1] = up[1];
        temp[2] = up[2];

        up[0] = left[0];
        up[1] = left[1];
        up[2] = left[2];

        left[0] = down[0];
        left[1] = down[1];
        left[2] = down[2];

        down[0] = right[0];
        down[1] = right[1];
        down[2] = right[2];

        right[0] = temp[0];
        right[1] = temp[1];
        right[2] = temp[2];
    }

    // ----getter et setter----
    public int[] getUp() {
        return up;
    }

    public void setUp(int[] up) {
        this.up = up;
    }

    public int[] getDown() {
        return down;
    }

    public void setDown(int[] down) {
        this.down = down;
    }

    public int[] getLeft() {
        return left;
    }

    public void setLeft(int[] left) {
        this.left = left;
    }

    public int[] getRight() {
        return right;
    }

    public void setRight(int[] right) {
        this.right = right;
    }

    public boolean isExistLeft() {
        return existLeft;
    }

    public void setExistLeft(boolean existLeft) {
        this.existLeft = existLeft;
    }

    public boolean isExistRight() {
        return existRight;
    }

    public void setExistRight(boolean existRight) {
        this.existRight = existRight;
    }

    public boolean isExistUp() {
        return existUp;
    }

    public void setExistUp(boolean existUp) {
        this.existUp = existUp;
    }

    public boolean isExistDown() {
        return existDown;
    }

    public void setExistDown(boolean existDown) {
        this.existDown = existDown;
    }
// ----getter et setter----
}
