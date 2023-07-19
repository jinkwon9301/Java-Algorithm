class Solution {
    public int solution(int[] num_list) {
        
        int count = 0;
        
        for (int i : num_list) {
            while(i != 1) {
                if (i % 2 == 0) {
                    i /= 2;
                }
                else {
                    i = (i - 1) / 2;
                }
                count++;
            }
        }
        
        return count;
    }
}