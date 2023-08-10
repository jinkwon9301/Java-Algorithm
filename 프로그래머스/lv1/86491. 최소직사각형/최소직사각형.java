class Solution {
    public int solution(int[][] sizes) {
        int x = 0;
        int y = 0;
        
        for (int[] square : sizes) {
            if (x < Math.max(square[0], square[1]))
                x = Math.max(square[0], square[1]);
            if (y < Math.min(square[0], square[1]))
                y = Math.min(square[0], square[1]);
        }
        
        return x * y;
    }
}