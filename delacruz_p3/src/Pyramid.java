public class Pyramid extends Shape3D {
    private double length, width, height;
    Pyramid(int length, int width, int height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    Pyramid(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }
    public String getName(){
        return "pyramid";
    }
    public double getArea(){
        return (this.length*this.width) +
                this.length*(Math.sqrt(Math.pow(this.width/2.0, 2.0)+Math.pow(this.height,2.0))) +
                this.width*Math.sqrt(Math.pow(this.length/2.0,2.0)+Math.pow(this.height,2.0));
    }
    public double getVolume(){
         return (this.height*this.length*this.width)/3;
    }

}
