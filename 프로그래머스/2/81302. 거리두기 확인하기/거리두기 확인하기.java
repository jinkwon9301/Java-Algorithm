class Solution {
  static private int[] answer;

  // 상하좌우 배열
  static private int[] dx = {1, -1, 0, 0};
  static private int[] dy = {0, 0, 1, -1};

  // 방문확인 배열
  static private boolean[][] visited;
    
  static private void dfs(int y, int x, int num, int depth, String[] place) {
    // depth가 3 이상이면 그냥 return;
    if (depth > 2) return;

    // depth가 0 이상이고 2 이하면서 현재 위치가 'P'이면 answer[num] = 0; 하고 return;
    if (0 < depth && depth <= 2 && place[y].charAt(x) == 'P') {
      answer[num] = 0;
      return;
    }

    // 상하좌우 이동하며 dfs 탐색한다.
    for (int i = 0; i < dx.length; i++) {
      int nx = x + dx[i];
      int ny = y + dy[i];

      // 방문할 곳이 범위를 벗어나거나 'X'인지 확인한다.
      if (0 <= nx && nx < 5 && 0 <= ny && ny < 5 && place[ny].charAt(nx) != 'X') {
        // 이미 방문한 곳일 경우 생략
        if (visited[ny][nx]) continue;
        visited[ny][nx] = true;
        dfs(ny, nx, num, depth + 1, place);
        visited[ny][nx] = false;
      }
    }
  }

  public int[] solution(String[][] places) {

    // answer를 담을 배열 필요함.
    answer = new int[places.length];
    // 미리 1을 담아두고 예외의 경우만 0으로 바꿔주도록 하자
    for (int i = 0; i < answer.length; i++) {
      answer[i] = 1;
    }

    for (int i = 0; i < places.length; i++) {
      // 방문배열 초기화
      visited = new boolean[5][5];

      for (int j = 0; j < places[i].length; j++) {
        for (int k = 0; k < places[i][j].length(); k++) {
          if (places[i][j].charAt(k) == 'P') {
            // 'P'면 방문한다.
            visited[j][k] = true;
            // dfs 탐색 시작
            dfs(j, k, i, 0, places[i]);
            // 방문 해제
            visited[j][k] = false;
          }
        }
      }
    }
    
    return answer;
  }
}