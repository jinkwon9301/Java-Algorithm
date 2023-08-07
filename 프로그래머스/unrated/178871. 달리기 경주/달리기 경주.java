// List에 현재 등수를 저장하고 .indexOf() 메소드를 사용하여 callings 대상의 인덱스를 찾는 경우 배열을 순회하며 찾기때문에 크기가 커지는 만큼 시간복잡도가 늘어납니다.
// 따라서 HashMap에 저장 후 .get() 메소드를 사용하여 callings 대상의 현재 인덱스를 바로 찾아 Array에 반영하고 HashMap에도 수정된 등수를 반영하여 Array와 HashMap을 동기화하는 방식의 반복을 통해 마지막 callings 까지 처리한다면 타임아웃 없이 해결 가능합니다.
import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        
        Map<String, Integer> map = new HashMap<>();
        int back_idx = 0;
        int front_idx = 0;
        
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for (int i = 0; i < callings.length; i++) {
            back_idx = map.get(callings[i]);
            front_idx = back_idx - 1;
            
            String tmp = players[front_idx];
            players[front_idx] = players[back_idx];
            players[back_idx] = tmp;
            
            map.put(players[back_idx], back_idx);
            map.put(players[front_idx], front_idx);
        }
        
        return players;
//         실패 코드
        
//         int back_idx = 0;
//         int front_idx = 0;
        
//         for (int i = 0; i < callings.length; i++) {
//             String back = callings[i];
//             for (int j = 0; j < players.length; j++) {
//                 if (players[j].equals(back)) {
//                     back_idx = j;
//                     front_idx = j - 1;
                    
//                     String tmp = "";
//                     tmp = players[front_idx];
//                     players[front_idx] = players[back_idx];
//                     players[back_idx] = tmp;
                    
//                     System.out.println(Arrays.toString(players));
//                     break;
//                 }
//             }
//         }
//         return players;
    }
}