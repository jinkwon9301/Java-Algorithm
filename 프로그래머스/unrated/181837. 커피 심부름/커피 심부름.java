class Solution {
    public int solution(String[] order) {
        int answer = 0;
        
        for (String str : order) {
            if (str.equals("iceamericano") || 
                str.equals("americanoice") || 
                str.equals("hotamericano") || 
                str.equals("americanohot") || 
                str.equals("americano") || 
                str.equals("anything")
               ) answer += 4500;
            else answer += 5000;
        }
        
        return answer;
    }
}