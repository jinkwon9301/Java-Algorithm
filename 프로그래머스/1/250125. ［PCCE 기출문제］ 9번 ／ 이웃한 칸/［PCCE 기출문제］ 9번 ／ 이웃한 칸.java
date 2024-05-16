class Solution {
    public int solution(String[][] board, int h, int w) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int length = board.length;
        String color = board[h][w];
        int result = 0;
        
        for(int i = 0; i < 4; i++) {
            int nx = w + dx[i];
            int ny = h + dy[i];
            
            if (0 <= nx && nx < length && 0 <= ny && ny < length) {
                if (board[ny][nx].equals(color)) {
                    result++;
                }
            }
        }
        
        return result;
    }
}