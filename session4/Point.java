package session4;
public class Point {
    public float x;
    public float y;

    public Point() {
    }

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
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
    public String toString(){
        return "("
                +getX()
                +getY()
                +")";
    }

    public static void main(String[] args) {
        System.out.print("Point ");
        Point point = new Point();
        System.out.println(point);
        point = new Point(6,8);
        System.out.print(point + "\t");
    }
}