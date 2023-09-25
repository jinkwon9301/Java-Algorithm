class Solution {
    public String solution(String s) {
        String[] arr = s.split(" ");
        int min = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
          if (i == 0) {
            min = Integer.parseInt(arr[i]);
            max = Integer.parseInt(arr[i]);
          }
          else {
            if (max < Integer.parseInt(arr[i])) {
              max = Integer.parseInt(arr[i]);
            }
            if (Integer.parseInt(arr[i]) < min) {
              min = Integer.parseInt(arr[i]);
            }
          }
        }
        
        return min + " " + max;
    }
}