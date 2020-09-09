public class Application {
    public static void main(String[] args){
        Encrypter e = new Encrypter();
        String enc = e.encrypt("1234");
        System.out.println(enc);
        Decrypter d = new Decrypter();
        String dec = d.decrypt("0189");
        System.out.println(dec);
    }
}
