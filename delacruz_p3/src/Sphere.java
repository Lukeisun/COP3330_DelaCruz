public class Sphere extends Shape3D {
    private double radius;
    Sphere(int radius){
        this.radius = radius;
    }
    Sphere(double radius){
        this.radius = radius;
    }
    public String getName(){
        return "sphere";
    }
    public double getArea(){
        return 4.0*Math.PI*Math.pow(radius,2);
    }
    public double getVolume(){
        return (4.0/3.0)*Math.PI*Math.pow(radius,3);
    }
}
