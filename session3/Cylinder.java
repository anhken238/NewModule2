package session3;

public class Cylinder extends Circle {
    public double height;

    public Cylinder() {

    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }
    public double getVolume(){
        return Math.PI * Math.pow(radius,2)*height;
    }

    @Override
    public String toString() {
        return super.toString()
                + " Chiều cao : "
                +getHeight();
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(4,"Hồng",16);
        System.out.println(cylinder);
        System.out.println("Thê tích là : " + cylinder.getVolume());
    }
}
