public class Application {
    public static void main(String[] args){
        String test = "1234";
        Encrypter e = new Encrypter();
        String enc = e.encrypt(test);
        System.out.println(enc);
        Decrypter d = new Decrypter();
        String dec = d.decrypt(enc);
        System.out.println(dec);
    }
}
