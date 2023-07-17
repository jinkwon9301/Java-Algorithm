class Solution {
    public int solution(int[] arr1, int[] arr2) {
        
        int arr1_sum = 0;
        int arr2_sum = 0;
        
        if (arr1.length > arr2.length) return 1;
        else if (arr1.length < arr2.length) return -1;
        else {
            for (int a : arr1) {
                arr1_sum += a;
            }
            for (int b : arr2) {
                arr2_sum += b;
            }
            if (arr1_sum > arr2_sum) return 1;
            else if (arr1_sum < arr2_sum) return -1;
            else return 0;
        }
    }
}