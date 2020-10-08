public class Triangle extends Shape2D {
    private double length;
    private double width;
    Triangle(int length, int width){
        this.length = length;
        this.width = width;
    }
    Triangle(double length, double width){
        this.length = length;
        this.width = width;
    }
    public String getName(){
        return "triangle";
    }
    public double getArea(){
        return (0.5)*(this.length)*this.width;
    }
}
