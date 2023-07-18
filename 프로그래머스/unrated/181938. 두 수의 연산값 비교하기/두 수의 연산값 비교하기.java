class Solution {
    public int solution(int a, int b) {
        
        int A = Integer.parseInt(""+a+b);
        int B = (2 * a * b);
        
        return (A >= B) ? A : B; 
        
    }
}