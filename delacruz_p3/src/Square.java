public class Square extends Shape2D {
    private double side;
    Square(int area){
        this.side = area;
    }
    Square(double area){
        this.side = area;
    }
    public String getName(){
        return "square";
    }
    public double getArea(){
        return this.side * this.side;
    }

}
