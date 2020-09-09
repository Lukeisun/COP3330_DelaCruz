public class Decrypter {
    public String decrypt(String toBeDecrypted){
        int[] strToIntArr = strToInt(toBeDecrypted);
        String retString = "";
        return retString;
    }
    public int[] strToInt(String s){
        int[] retVal = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            int valOfIdx = Character.getNumericValue(c);
            if(valOfIdx >= 3){
                retVal[i] = valOfIdx + 3;
            } else {
                retVal[i] = valOfIdx + 7;
            }
        }
        return retVal;
    }
}
