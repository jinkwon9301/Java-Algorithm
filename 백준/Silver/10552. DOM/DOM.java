import java.util.*;

public class Main {
    static int count = 0;
    static int[] toFavouriteCH = new int[100000 + 1];
    static boolean[] visited = new boolean[100000 + 1];
    static public void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 시청자 수
        int m = sc.nextInt(); // 채널 수 1 to m
        int p = sc.nextInt(); // 최초 채널


        while(--n >= 0) {
            int favouriteCH = sc.nextInt();
            int hatedCH = sc.nextInt();

            if (toFavouriteCH[hatedCH] == 0) toFavouriteCH[hatedCH] = favouriteCH;
        }

        changeChannel(p);

        System.out.print(count);
    }

    static public void changeChannel(int ch) {
        if (visited[ch]) count = -1;
        else if (toFavouriteCH[ch] != 0) {
            count++;
            visited[ch] = true;
            changeChannel(toFavouriteCH[ch]);
        }
    }
}