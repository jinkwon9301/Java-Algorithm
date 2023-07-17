class Solution {
    public String solution(String myString) {
    
        String toL = "abcdefghijk";
        
        StringBuffer sb = new StringBuffer();
        
        for (int i = 0; i < myString.length(); i++) {
            if (toL.contains(myString.charAt(i) + "")) sb.append("l");
            else sb.append(myString.charAt(i));
        }
        
        return sb.toString();
    }
}