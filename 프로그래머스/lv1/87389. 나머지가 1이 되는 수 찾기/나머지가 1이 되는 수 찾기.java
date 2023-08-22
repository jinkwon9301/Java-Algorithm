class Solution {
    public int solution(int n) {
        int num = 2;
        while (true) {
          if ((n - 1) % num == 0) return num;
          num++;
        }
    }
}