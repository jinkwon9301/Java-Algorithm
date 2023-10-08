class Solution {
    public int[] solution(int brown, int yellow) {
        int x = 0;
        int y = 0;
        int[] result = {0, 0};
        
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                y = i;
                x = yellow / i;
                if ((x + 2) * (y + 2) - yellow == brown) {
                    result = new int[] {x + 2, y + 2};
                    break;
                }
            }           
        }
        
        return result;
    }
}