public class Encrypter{
    public String encrypt(String toBeEncrypted){
        int[] strToIntArr;
        strToIntArr = strToInt(toBeEncrypted);
        return makingRetVal(strToIntArr);
    }

    //makes an int array of the converted values ex 0->7, 1->8, 3->0 and so forth. Returns said int array.
    private int[] strToInt(String s){
        int[] val = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            val[i] = (Character.getNumericValue(c) + 7)%10;
        }
        return val;
    }

    //returns the value to be returned in the encrypt func, swaps around the places of the values to the correct ones.
    private String makingRetVal(int[] val){
        String ret = "";
        int radix = 10;
        int[] orderToChange = {2,3,0,1};
        for (int j : orderToChange) ret += Character.forDigit(val[j], radix);
        return ret;
    }
}