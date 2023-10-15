// import java.util.*;

// class Solution {
//     public int solution(int[] citations) {

//         int start = 0;
//         int end = 0;
//         int mid = 0;
//         int h = 0;
//         int count = 0;
//         int[] arr;
//         int max = 0;

//         for (int citation : citations) {
//           if (citation > max) max = citation;
//         }
        
//         if (max == 0) return 0;

//         arr = new int[max + 1];
//         for (int i = 0; i < arr.length; i++) {
//           arr[i] = i;
//         }

//         end = arr.length - 1;

//         while (end - start != 1) {
//           mid = (start + end) / 2;
//           h = arr[mid];

//           for (int i = 0; i < citations.length; i++) {
//             if(citations[i] >= h) count++;
//           }

//           if (count >= h) start = mid;
//           else  end = mid;

//           count = 0;
//         }

//         for (int i = 0; i < citations.length; i++) {
//           if(citations[i] >= end) count++;
//         }

//         if (count >= end) return end;
//         else return start;
//     }
// }

import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=0; i<citations.length; i++){
            int smaller = Math.min(citations[i], citations.length-i);
            answer = Math.max(answer, smaller);
        }
        return answer;
    }
}