class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[]{ -1 };
        int min = arr[0];
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                idx = i;
            }
        }
        int[] result = new int[arr.length - 1];
        for (int i = 0; i < result.length; i++) {
            if (i < idx) result[i] = arr[i];
            else result[i] = arr[i + 1];
        }
        return result;
    }
}