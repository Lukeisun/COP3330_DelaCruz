import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        Scanner p = new Scanner(System.in);
        while(true) {
            String str = p.nextLine();
            Encrypter e = new Encrypter();
            String enc = e.encrypt(str);
            System.out.println(enc);
            Decrypter d = new Decrypter();
            String dec = d.decrypt(enc);
            System.out.println(dec);
            if(str.equalsIgnoreCase("quit")) break;
        }
    }
}
