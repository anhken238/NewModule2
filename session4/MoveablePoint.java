package session4;

public class MoveablePoint extends Point {
    public float xSpeed;
    public float ySpeed;

    public MoveablePoint() {

    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }
    public float getYSpeed(){
        return ySpeed;
    }
    public void setYSpeed(float ySpeed){
        this.ySpeed=ySpeed;
    }
    public float[] getSpeed(){
        float[] arr = new float[2];
        arr[0] = this.xSpeed;
        arr[1] = this.ySpeed;
        return arr;
    }
    public void setSpeed(float xSpeed,float ySpeed){
        this.xSpeed=xSpeed;
        this.ySpeed=ySpeed;
    }


    @Override
    public String toString() {
        return super.toString()
                +","
                +"Speed ("
                + getXSpeed()
                +","
                +getYSpeed()
                +")";
    }
    public float[] move(){
        x+=xSpeed;
        y+=ySpeed;
        return getXY();
    }

    public static void main(String[] args) {
        System.out.print("MoveablePoint");
        MoveablePoint moveablePoint = new MoveablePoint();
        System.out.println(moveablePoint);
        moveablePoint = new MoveablePoint(1,2,3,4);
        System.out.print(moveablePoint + "\n");
    }}

