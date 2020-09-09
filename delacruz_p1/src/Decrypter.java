public class Decrypter{
    public String decrypt(String toBeDecrypted){
        int[] strToIntArr = strToInt(toBeDecrypted);
        return makingRetVal(strToIntArr);
    }

    //makes an int array of what the values originally were, 7->0 8->1 6->9 and so forth. Returns said int array
    private int[] strToInt(String s){
        int[] retVal = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int valOfIdx = Character.getNumericValue(c);
            //I noticed that 0,1,2 when encrypted (7,8,9) just needed to be subtracted by 7 and greater values just needed to be added by 3
            if(valOfIdx < 7){
                retVal[i] = valOfIdx + 3;
            } else {
                retVal[i] = valOfIdx - 7;
            }
        }
        return retVal;
    }

    //returns the value to be returned in the decrypt func, swaps around the places of the values to the correct ones.
   private String makingRetVal(int[] val){
        String ret = "";
        int radix = 10;
        int[] orderToChange = {2,3,0,1};
        for(int i: orderToChange) ret += Character.forDigit(val[i], radix);
        return ret;
    }
}
