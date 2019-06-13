package session3;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = 1;
    private double radius = 5;
    private String color = "blue";
    private boolean on = false;

    public Fan(){

    }

    public  Fan( int speed, boolean on, String color,double radius ){
        this.speed =  speed ;
        this.on = on ;
        this.color = color;
        this.radius = radius;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isOn() {
        return on;
    }

    public String getColor() {
        return color;
    }

    public double getRadius() {
        return radius;
    }


    public String toString() {
        return " " +getSpeed() + " " + isOn() + " " + getColor() + " " +getRadius();
    }

    public static void main(String[] args) {
        Fan fan = new Fan();
        System.out.println(fan);
        fan = new Fan(2,true,"yellow",10);
        System.out.println(fan);
    }
}
