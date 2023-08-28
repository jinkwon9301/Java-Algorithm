import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set set = new TreeSet();
        int num = 0;

        for (int i = 0; i < numbers.length; i++) {
          for (int j = i + 1; j < numbers.length; j++) {
            num = numbers[i] + numbers[j];
            set.add(num);
          }
        }
        
        int[] result = new int[set.size()];
        int i = 0;
        for (Object o : set) {
          result[i++] = (Integer) o;
        }
        
        return result;
    }
}