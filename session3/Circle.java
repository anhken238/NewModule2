package session3;

public class Circle {
    public double radius;
    public String color;

    public Circle() {
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }



    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public double getAcreage() {
        return Math.PI * Math.pow(radius,2);
    }


    public String toString() {
        return "Bán Kính"
                + getRadius()
                + " Màu "
                + getColor();
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(6, "đỏ");
        System.out.println(circle);
        System.out.print("Diện tích hình tròn :" + circle.getAcreage());
    }
}
