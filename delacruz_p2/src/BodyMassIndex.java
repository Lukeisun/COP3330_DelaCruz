public class BodyMassIndex {
    double height, weight;
    BodyMassIndex(double height, double weight){
        this.height = height;
        this.weight = weight;
    }

    public double BMIScore(){
        return Math.round(703*( this.weight / Math.pow(this.height, 2)) *10.0)/10.0;
    }

    public String BMICat(){
        double BMI = BMIScore();
        if(BMI < 18.5){
            return "User is underweight: < 18.5";
        } else if(BMI < 25){
            return "User is normal weight: 18.5 - 24.9";
        } else if(BMI < 30){
            return "User is overweight: 25-29.9";
        } else {
            return "User is obese: >= 30";
        }
    }

}
