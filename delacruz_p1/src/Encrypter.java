public class Encrypter{
    public String encrypt(String toBeEncrypted){
        int[] strToIntArr;
        strToIntArr = strToInt(toBeEncrypted);
        String encryptedString;
        encryptedString = makingRetVal(strToIntArr);
        return encryptedString;
    }

    private int[] strToInt(String s){
        int[] val = new int[4];
        for(int i=0; i<s.length(); i++){
            val[i] = (Character.getNumericValue(s.charAt(i)) + 7)%10;
        }
        return val;
    }

    private String makingRetVal(int[] val){
        String ret = "";
        int radix = 10;
        int[] orderToChange = {2,3,0,1};
        for (int j : orderToChange) ret += Character.forDigit(val[j], radix);
        return ret;
    }
}