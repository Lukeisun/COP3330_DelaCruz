public class Encrypter {
    public String encrypt(String toBeEncrypted){
        String retString = "";
        int radix = 10;
        int[] asciiVal = new int[4];
        for(int i=0; i<toBeEncrypted.length(); i++){
            asciiVal[i] = (Character.getNumericValue(toBeEncrypted.charAt(i)) + 7)%10;
        }
        retString += Character.forDigit(asciiVal[2],radix);
        retString += Character.forDigit(asciiVal[3], radix);
        retString += Character.forDigit(asciiVal[0],radix);
        retString += Character.forDigit(asciiVal[1],radix);
        return retString;

    }
}
