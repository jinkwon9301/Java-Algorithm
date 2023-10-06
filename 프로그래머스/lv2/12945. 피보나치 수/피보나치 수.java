import java.util.*;

class Solution {
    public int solution(int n) {
        
        if (n == 2) return 1;
        
        List<Long> list = new ArrayList<>();
        list.add(0L);
        list.add(1L);
        list.add(1L);
        int count = 3;

        while (count <= n) {
          fibo(count++, list);
        }

        return (int) (list.get(n) % 1234567);
    }
    
  static void fibo(int n, List<Long> list) {
    list.add((list.get(n - 2) + list.get(n - 1)) % 1234567);
  }
}