package session4;

public class Pont3d extends Pont2d {
    public float z;

    public Pont3d() {
    }
    public Pont3d(float x,float y,float z){
        super(x,y);
        this.z=z;
    }
    public float getZ(){
        return this.z;
    }
    public void setZ(float z){
        this.z=z;
    }
    public float[] getXYZ(){
        float[] arr = new float[3];
        arr[0] = this.x;
        arr[1] = this.y;
        arr[2] = this.z;
        return arr;
    }

    @Override
    public String toString() {
        return super.toString()
                +" Z : "
                + getZ();
    }

    public static void main(String[] args) {
        System.out.print("Point 3D ");
        Pont3d pont3d = new Pont3d();
        System.out.println(pont3d);
        pont3d = new Pont3d(10,20,30);
        System.out.print(pont3d + "\t");
    }
}
