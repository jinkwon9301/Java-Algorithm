class Solution {
    public String solution(int[] food) {
        int[] food_even = new int[food.length];
        StringBuffer sb = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        for (int i = 0; i < food.length; i++) {
          if (food[i] % 2 == 0) food_even[i] = food[i] / 2;
          else food_even[i] = (food[i] - 1) / 2;
        }

        for (int i = 1; i < food_even.length; i++) {
          for (int j = 0; j < food_even[i]; j++) {
            sb.append(i);
          }
        }

        for (int i = food_even.length - 1; i > 0; i--) {
          for (int j = 0; j < food_even[i]; j++) {
            sb2.append(i);
          }
        }
        
        return sb.append(0).append(sb2).toString();
    }
}