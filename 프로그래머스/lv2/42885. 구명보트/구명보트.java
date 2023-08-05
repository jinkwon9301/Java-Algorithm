import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int front = 0;
        int end = people.length - 1;
        int count = 0;
        
        Arrays.sort(people);
        
        while (front <= end) {
            if (people[front] + people[end] > limit) {
                end--;
                count++;
            } else {
                end--;
                front++;
                count++;
            }
        }
        return count;
    }
}