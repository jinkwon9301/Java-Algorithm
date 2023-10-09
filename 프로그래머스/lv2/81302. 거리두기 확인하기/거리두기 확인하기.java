class Solution {
    public int[] solution(String[][] places) {
        int[] result = new int[places.length];

        for (int i = 0; i < places.length; i++) {
          result[i] = isOK(places[i]);
        }
        
        return result;
    }
    
  static int isOK(String[] place) {
    for (int i = 0; i < place.length; i++) {
      for (int j = 0; j < place[i].length(); j++) {
        if (place[i].charAt(j) == 'P') {
          if (!(dfs(0, i - 1, j, 'T', place) &&
              dfs(0, i + 1, j, 'B', place) &&
              dfs(0, i, j - 1, 'L', place) &&
              dfs(0, i, j + 1, 'R', place)))
            return 0;
        }
      }
    }

    return 1;
  }
    
  static boolean dfs(int count, int y, int x, char direction, String[] place) {
    if (x < 0 || x > 4 || y < 0 || y > 4) return true;

    if (place[y].charAt(x) == 'X') return true;
    count++;
    if (place[y].charAt(x) == 'O') {
      if (count == 3) return true;
    }
    if (place[y].charAt(x) == 'P') {
      return (count <= 2) ? false : true;
    }

    if (direction == 'T') {
      if (!(dfs(count, y - 1, x, 'T', place) &&
            dfs(count, y, x - 1, 'L', place) &&
            dfs(count, y, x + 1, 'R', place)))
        return false;
    }

    else if (direction == 'B') {
      if (!(dfs(count, y + 1, x, 'B', place) &&
            dfs(count, y, x - 1, 'L', place) &&
            dfs(count, y, x + 1, 'R', place)))
        return false;
    }

    else if (direction == 'L') {
      if (!(dfs(count, y - 1, x, 'T', place) &&
            dfs(count, y + 1, x, 'B', place) &&
            dfs(count, y, x - 1, 'L', place)))
        return false;
    }

    else if (direction == 'R') {
      if (!(dfs(count, y - 1, x, 'T', place) &&
            dfs(count, y + 1, x, 'B', place) &&
            dfs(count, y, x + 1, 'R', place)))
        return false;
    }

    return true;
  }
}