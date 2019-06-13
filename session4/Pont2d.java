package session4;

public class Pont2d {
    public float x;
    public float y;

    public Pont2d() {
    }

    public Pont2d(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        float[] arr = new float[2];
        arr[0] = this.x;
        arr[1] = this.y;
        return arr;
    }

    public void setXY(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "X : "
                + getX()
                + " Y : "
                + getY();
    }

    public static void main(String[] args) {
        System.out.println("Point 2D");
        Pont2d pont2d = new Pont2d();
        System.out.print(pont2d);
        pont2d = new Pont2d(10,20);
        System.out.print(pont2d);
    }

}
