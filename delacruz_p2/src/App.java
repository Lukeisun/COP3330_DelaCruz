import java.util.ArrayList;
import java.util.Scanner;
public class App {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    private static Boolean moreInput(){
        System.out.println("Type in Y/N if you would like to add more input");
        String yOrN = scan.nextLine();
        if(yOrN.equals("Y")){
            return true;
        } else if(yOrN.equals("N")){
            return false;
        } else {
            System.out.println("Invalid input, please type Y/N");
            return moreInput();
        }
    }

    private static double getUserHeight(){
        System.out.println("Please type in your height in INCHES");
        while(!scan.hasNextDouble()) {
            System.out.println("Not a numerical value");
            scan.next();
        }
        double retVal = scan.nextDouble();
        scan.nextLine();
        if(retVal < 0.0){
            System.out.println("Non-negative input please");
            return getUserHeight();
        } else {
            return retVal;
        }
    }

    private static double getUserWeight(){
        System.out.println("Please type in your weight in POUNDS");
        while(!scan.hasNextDouble()) {
            System.out.println("Not a numerical value");
            scan.next();
        }
        double retVal = scan.nextDouble();
        scan.nextLine();
        if(retVal < 0.0){
            System.out.println("Non-negative input please");
            return getUserWeight();
        } else {
            return retVal;
        }
    }

    private static void displayBmiInfo(BodyMassIndex bmi){
        System.out.println("Users BMI Score is: " + bmi.BMIScore());
        System.out.println(bmi.BMICat() + "\n");
    }

    private static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        double totalBMI = 0;
        for(int i=0; i< bmiData.size(); i++) {
            totalBMI += bmiData.get(i).BMIScore();
            if (i == (bmiData.size() - 1)) totalBMI /= (i + 1);
        }
        System.out.println("Average BMI score is: " + Math.round(10.0*totalBMI)/10.0);
    }

}


