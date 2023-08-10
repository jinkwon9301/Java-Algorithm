// 풀이 출처 : [프로그래머스] 공원 산책 자바 (https://iyk2h.tistory.com/348)

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
     // 좌표 변수를 선언한다.
    int x = 0;
    int y = 0;

    // 공원을 만들기 위해 2차원 배열을 생성한다.
    char[][] park_2D = new char[park.length][park[0].length()];

    // 인자로 들어오는 값을 대입해 공원을 초기화하고 시작지점을 설정해준다.
    for (int i = 0; i < park_2D.length; i++) {
      for (int j = 0; j < park_2D[0].length; j++) {
        park_2D[i][j] = park[i].charAt(j);
        if (park_2D[i][j] == 'S') {
          x = j;
          y = i;
        }
      }
    }

    for (int i = 0; i < routes.length; i++) {
      char direction = routes[i].charAt(0);
      int distance = routes[i].charAt(2) - '0';

      // (막다른 길에 막히거나 장애물 S를 만나면)
      // 결과적으로 이동하지 않을 수도 있기 때문에 임시 좌표 변수를 만들어준다.
      int nx = x;
      int ny = y;

      // 한칸씩 이동하며 제한사항 (막다른 길에 막히거나 장애물 S를 만난다.) 에 해당하는지 확인
      for (int j = 1; j <= distance; j++) {
        if (direction == 'E') nx++;
        else if (direction == 'W') nx--;
        else if (direction == 'S') ny++;
        else if (direction == 'N') ny--;

        // 제한 사항에 걸리면 반복문 탈출
        if (!(0 <= nx && nx < park_2D[0].length && 0 <= ny && ny < park_2D.length) || park_2D[ny][nx] == 'X') break;

        // 제한사항에 걸리지 않고 끝까지 왔다면 임시좌표를 좌표에 대입한다.
        if (j == distance) { x = nx; y = ny; }
      }
    }

    return new int[] { y, x };
        
    }
}