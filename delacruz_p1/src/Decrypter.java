public class Decrypter {
    public String decrypt(String toBeDecrypted){
        int[] strToIntArr = strToInt(toBeDecrypted);
        String retString = makingRetVal(strToIntArr);
        return retString;
    }
    private int[] strToInt(String s){
        int[] retVal = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int valOfIdx = Character.getNumericValue(c);
            if(valOfIdx <= 3){
                retVal[i] = valOfIdx + 3;
            } else {
                retVal[i] = valOfIdx - 7;
            }
        }
        return retVal;
    }
    private String makingRetVal(int[] val){
        String ret = "";
        int radix = 10;
        int[] orderToChange = {2,3,0,1};
        for(int i: orderToChange) ret += Character.forDigit(val[i], radix);
        return ret;
    }
}
