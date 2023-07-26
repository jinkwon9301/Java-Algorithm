import java.util.*;

class Solution {
    public int[][] solution(int n) {
        
        int[][] answer = new int[n][n];
        String direction = "right";
        int num = 1;
        int i = 0;
        int j = 0;
        
        while (num <= n * n) {
            if (direction == "right" && j < n && answer[i][j] == 0) {
                answer[i][j++] = num++;
            } else if (direction == "right" && j == n) {
                i++;
                j--;
                direction = "down";
            } else if (direction == "right" && answer[i][j] != 0) {
                i++;
                j--;
                direction = "down";
            } else if (direction == "down" && i < n && answer[i][j] == 0) {
                answer[i++][j] = num++;
            } else if (direction == "down" && i == n) {
                i--;
                j--;
                direction = "left";
            } else if (direction == "down" && answer[i][j] != 0) {
                i--;
                j--;
                direction = "left";
            } else if (direction == "left" && j >= 0 && answer[i][j] == 0) {
                answer[i][j--] = num++;
            } else if (direction == "left" && j == -1) {
                i--;
                j++;
                direction = "up";
            } else if (direction == "left" && answer[i][j] != 0) {
                i--;
                j++;
                direction = "up";
            } else if (direction == "up" && answer[i][j] == 0) {
                answer[i--][j] = num++;
            } else if (direction == "up" && answer[i][j] != 0) {
                i++;
                j++;
                direction = "right";
            }
        }
        
        return answer;
        
    }
}