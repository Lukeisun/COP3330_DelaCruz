public class Circle extends Shape2D {
    private double radius;
    Circle(int radius){
        this.radius = radius;
    }
    Circle(double radius){
        this.radius = radius;
    }
    public String getName(){
        return "circle";
    }
    public double getArea(){
        return Math.PI * (this.radius*this.radius);
    }
}
