package model;

public class Tuile {
    //protected static int id; a initier plus tard avec la classe joueur
    protected int[] up = new int[3];
    protected int[] down = new int[3];
    protected int[] left = new int[3];
    protected int[] right = new int[3];
    //protected boolean existLeft, existRight;

    public Tuile() {
        up[0] =     (int)Math.random();
        up[1] =     (int)Math.random();
        up[2] =     (int)Math.random();
        down[0] =   (int)Math.random();
        down[1] =   (int)Math.random();
        down[2] =   (int)Math.random();
        left[0] =   (int)Math.random();
        left[1] =   (int)Math.random();
        left[2] =   (int)Math.random();
        right[0] =  (int)Math.random();
        right[1] =  (int)Math.random();
        right[2] =  (int)Math.random();
    }

    public Tuile(int[] a, int[] b, int[] c, int[] d) {
        up = a;
        down = b;
        left = c;
        right = d;
    }

    //rotation sens aiguille sens montre
    public void rotation(){
        int[] upBis = up, downBis = down, leftBis = left, rightBis =right;
        up = leftBis;
        down = rightBis;
        right = upBis;
        left = downBis;
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
    // ----getter et setter----
}
