/*
출처 : [[프로그래머스 Level 2] 연속된 부분 수열의 합 (Java)](https://velog.io/@seowj0710/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-Level-2-%EC%97%B0%EC%86%8D%EB%90%9C-%EB%B6%80%EB%B6%84-%EC%88%98%EC%97%B4%EC%9D%98-%ED%95%A9-Java)

🌏문제풀이
전형적인 투 포인터를 활용하는 문제입니다.

while 문을 사용하여 sum(누적합)이 k보다 작을 때 까지 R의 값을 1씩 증가시키며 합을 구합니다. while 문이 종료된 후에, sum 값이 k와 같으면 문제의 조건에 맞게 수열의 길이를 비교하여 정답을 업데이트 해주면 문제를 해결할 수 있습니다.
*/

class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int N = sequence.length;
        int left = 0, right = N;
        int sum = 0;
        for(int L = 0, R = 0; L < N; L++) {
            while(R < N && sum < k) {
                sum += sequence[R++];
            }
            
            if(sum == k) {
                int range = R - L - 1;
                if((right - left) > range) {
                    left = L;
                    right = R - 1;
                }
            }
            
            sum -= sequence[L];
        }
        
        int[] answer = {left, right};
        
        return answer;
    }
}

// class Solution {
//     public int[] solution(int[] sequence, int k) {
//         // 투 포인터
//         int[] result = {0, 0};
//         int start = 0;
//         int end = 0;
//         int size = sequence.length;
//         int sum = 0;

//         while (true) {
//           sum = 0;

//           for (int i = start; i <= end; i++) {
//             sum += sequence[i];
//           }

//           if (sum < k) end++;
//           else if (k < sum) start++;
//           else if (k == sum) {
//             if (end - start < size) {
//               result[0] = start;
//               result[1] = end;
//               size = end - start;
//               if (size == 0) break;
//             }
//             start++;
//           }

//           if (end == sequence.length || start == end + 1) break;
//         }

//         return result;
//     }
// }