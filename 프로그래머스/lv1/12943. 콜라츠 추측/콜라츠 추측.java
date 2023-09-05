class Solution {
    public int solution(int num) {
        int i = 0;
        long n = num;
        if (n == 1) return 0;
        while (n != 1) {
            n = (n % 2 == 0) ? n / 2 : n * 3 + 1;
            i++;
            if (i == 500) return -1;
        }
        return i;
    }
}