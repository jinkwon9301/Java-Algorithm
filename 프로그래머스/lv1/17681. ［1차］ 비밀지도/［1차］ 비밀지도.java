/*
[비트기반 연산]

|는 겹쳐서 하나라도 1이면 1
&는 둘 다 1일 때만 1
^는 서로 다를 때 1

String.format("%ns", str)
%	포맷 시작
n	전체 너비 (문자 수)
s	문자열(String)

*/
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {

      String[] map = new String[n];

      for (int i = 0; i < n; i++) {
        int combined = arr1[i] | arr2[i];

        // 2진수 n자리로 변환 후, '1' -> '#', '0' -> ' '
        String line = String.format("%" + n + "s", Integer.toBinaryString(combined))
            .replace(' ', '0')  // 앞자리 0 채우기
            .replace('1', '#')
            .replace('0', ' ');

        map[i] = line;
      }

      return map;
    }
  }
