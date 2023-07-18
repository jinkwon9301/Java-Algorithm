import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String[] arr = a.split("");
        
        for (String e : arr) {
            System.out.println(e);
        }
    }
}