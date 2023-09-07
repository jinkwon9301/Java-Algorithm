class Solution {
    static int LCM(int n, int m) {
        int k = 0;
        while (n != m) {
            if (m > n) {
                k = n;
                n = m;
                m = k;
            }
            n = n - m;
        }
        return n;
    }
    
    public int[] solution(int n, int m) {
        
        return new int[]{LCM(n, m), n * m / LCM(n, m)};
    }
}