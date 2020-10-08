public class Cube extends Shape3D {
    private double side;
    Cube(int side){
        this.side = side;
    }
    Cube(double side){
        this.side = side;
    }
    public String getName(){
        return "cube";
    }
    public double getArea(){
        return 6.0*(Math.pow(side,2.0));
    }
    public double getVolume(){
        return (Math.pow(this.side, 3.0));
    }

}
