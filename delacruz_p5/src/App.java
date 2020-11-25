import java.util.Scanner;

public class App {
    public static void main(String[] args){
        int opt = 0;
        while(true) {
            System.out.println("Select your Application");
            System.out.println("--------------------------------------");
            System.out.println("1) task list");
            System.out.println("2) contact list");
            System.out.println("3) quit");
            opt = getAppInput();
            if(opt == 1){
                TaskApp taskApp = new TaskApp();
                taskApp.mainMenu();
            } else if (opt == 2){
                ContactApp contactApp = new ContactApp();
                contactApp.contactMenu();
            } else {
                System.out.println("Exiting");
                System.exit(0);
            }
        }
    }
    private static int getAppInput(){
        Scanner scan = new Scanner(System.in);
        int opt = 0;
        try {
            opt = scan.nextInt();
        } catch (Exception e){
            System.out.println("Must be an integer, enter new value");
            scan.nextLine();
            return getAppInput();
        }
        if (opt > 3 || opt <1) {
            System.out.println("Must be between 1-3, enter new value");
            return getAppInput();
        }
        return opt;
    }
}
