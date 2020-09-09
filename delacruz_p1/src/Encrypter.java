public class Encrypter {
    public String encrypt(String toBeEncrypted){
        String retString = "";
        int radix = 10;
        int[] strToIntArr = strToInt(toBeEncrypted);
        retString += Character.forDigit(strToIntArr[2],radix);
        retString += Character.forDigit(strToIntArr[3], radix);
        retString += Character.forDigit(strToIntArr[0],radix);
        retString += Character.forDigit(strToIntArr[1],radix);
        return retString;
    }
    private int[] strToInt(String s){
        int[] val = new int[4];
        for(int i=0; i<s.length(); i++){
            val[i] = (Character.getNumericValue(s.charAt(i)) + 7)%10;
        }
        return val;
    }
}
