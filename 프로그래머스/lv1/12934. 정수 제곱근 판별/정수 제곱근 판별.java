class Solution {
    public long solution(long n) {
        double num = Math.sqrt(n);
        double num2 = num % 1;
        if (num2 == 0) return (long) ((num + 1) * (num + 1));
        return -1;
    }
}