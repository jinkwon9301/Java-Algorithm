class Solution {
    public int[] solution(String[] wallpaper) {
        int x_max = 0;
        int x_min = wallpaper.length;
        int y_max = 0;
        int y_min = wallpaper[0].length();
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                char c = wallpaper[i].charAt(j);
                if (c == '#') {
                    x_min = Math.min(x_min, i);
                    x_max = Math.max(x_max, i);
                    
                    y_min = Math.min(y_min, j);
                    y_max = Math.max(y_max, j);
                }
            }
        }
        
        return new int[] { x_min, y_min, x_max + 1, y_max + 1 };
    }
}