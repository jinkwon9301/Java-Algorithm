class Solution {
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        long m = x;
        for(int i = 0; i < answer.length; i++) {
            answer[i] = m;
            m += x;
        }
        return answer;
    }
}