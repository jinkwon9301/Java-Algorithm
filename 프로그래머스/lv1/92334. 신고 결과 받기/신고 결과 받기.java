import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        HashMap<String, Integer> mapReportCount = new HashMap<>();
        HashMap<String, HashSet<String>> mapReporters = new HashMap<>();
        HashMap<String, Integer> mapGetMailCount = new HashMap<>();

        for (String log : report) {
          String[] logSplit = log.split(" ");
          String reporter = logSplit[0];
          String reported = logSplit[1];
          HashSet<String> reporters = new HashSet<>();
          boolean isDuplicate = false;

          if (!mapReporters.containsKey(reported))
            reporters = new HashSet<>();
          else
            reporters = mapReporters.get(reported);
          if (reporters.contains(reporter)) isDuplicate = true;
          reporters.add(reporter);
          mapReporters.put(reported, reporters);

          if (!isDuplicate) mapReportCount.put(reported, mapReportCount.getOrDefault(reported, 0) + 1);
        }
        
        for (String id : mapReportCount.keySet()) {
          Integer count = mapReportCount.get(id);
          if (count >= k) {
            HashSet<String> set = mapReporters.get(id);
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()) {
              String reporter = iterator.next();
              mapGetMailCount.put(reporter, mapGetMailCount.getOrDefault(reporter, 0) + 1);
            }
          }
        }

        int[] result = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
          if (mapGetMailCount.containsKey(id_list[i])) {
            result[i] = mapGetMailCount.get(id_list[i]);
          } else {
            result[i] = 0;
          }
        }
        
        return result;
    }
}