class Solution {
    public int solution(int a, int b) {
        
        int A = Integer.parseInt("" + a + b);
        int B = Integer.parseInt("" + b + a);
        
        if (A >= B) return A;
        else return B;
        
    }
}