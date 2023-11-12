import java.util.*;

class Solution {
    public int[] solution(String msg) {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    int mapValue = 1;
    int startIdx = 0;
    int endIdx = 0;
    Map<String, Integer> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    String word = "";
    String prevWord = "";

    for (int i = 0; i < alphabet.length(); i++) {
      map.put(alphabet.charAt(i) + "", mapValue++);
    }

    for (int i = 0; i < msg.length(); i++) {
      startIdx = i;
      endIdx = i + 1;

      while (true) {
        if (endIdx == msg.length() + 1) {
          prevWord = msg.substring(startIdx, endIdx - 1);
          list.add(map.get(prevWord));
          break;
        }

        word = msg.substring(startIdx, endIdx);
        prevWord = msg.substring(startIdx, endIdx - 1);

        if (map.get(word) != null) {
          endIdx++;
          continue;
        } else {
          list.add(map.get(prevWord));
          map.put(word, mapValue++);
          break;
        }
      }

      i = endIdx - 2;
    }

    return list.stream().mapToInt(i -> i).toArray();
    }
}