import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        LinkedList<String> list = new LinkedList<>();
        int time = 0;
        String city = "";

        for (int i = 0; i < cities.length; i++) {
          city = cities[i].toLowerCase();

          if (list.size() < cacheSize) {
            if (list.contains(city)) {
              list.remove(list.indexOf(city));
              time += 1;
            } else {
              time += 5;
            }
          } else {
            if (list.contains(city)) {
              list.remove(list.indexOf(city));
              time += 1;
            } else {
              list.removeFirst();
              time += 5;
            }
          }
          list.add(city);
        }

        return time;
    }
}