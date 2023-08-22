import java.util.*;

class Solution {
    public int solution(String[] babblings) {
        // "aya", "ye", "woo", "ma" 4가지 발음만 가능
        int answer = 0;
        for(int i = 0; i < babblings.length; i++) {
            if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
                continue;
            }

            babblings[i] = babblings[i].replace("aya", " ");
            babblings[i] = babblings[i].replace("ye", " ");
            babblings[i] = babblings[i].replace("woo", " ");
            babblings[i] = babblings[i].replace("ma", " ");
            babblings[i] = babblings[i].replace(" ", "");

            if(babblings[i].length()  == 0) answer++;

        }
        return answer;
        
//         Map<String, Integer> map = new HashMap<>();
        
//         map.put("aya", 1);
//         map.put("ye", 1);
//         map.put("woo", 1);
//         map.put("ma", 1);

//         int result = 0;
//         int count = 0;
//         String last_babble = "";
//         String babble = "";

//         for (int i = 0; i < babbling.length; i++) {
//           boolean canBabble = true;
//           for (int j = 0; j < babbling[i].length(); j++) {
//             count++;
//             if (count == 1 && j == babbling[i].length() - 1) {
//               canBabble = false;
//               break;
//             } else if (count == 2) {
//               babble = babbling[i].substring(j - 1, j + 1);
//               if (map.get(babble) != null && !babble.equals(last_babble)) {
//                 count = 0;
//                 last_babble = babble;
//               } else {
//                 if (j == babbling[i].length() - 1) {
//                   canBabble = false;
//                   break;
//                 }
//               }
//             } else if (count == 3) {
//               babble = babbling[i].substring(j - 2, j + 1);
//               if (map.get(babble) != null && !babble.equals(last_babble)) {
//                 count = 0;
//                 last_babble = babble;
//               } else {
//                 canBabble = false;
//                 break;
//               }
//             }
//           }
//           if (canBabble) result++;
//           count = 0;
//           last_babble = "";
//         }
        
//         return result;
    }
}