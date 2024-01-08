import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    
  static int N, M;
  static int[][] A, B;
    
  public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] sarr = br.readLine().split(" ");
		N = Integer.parseInt(sarr[0]);
		M = Integer.parseInt(sarr[1]);

		A = new int[N][M];
		B = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				A[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				B[i][j] = str.charAt(j) - '0';
			}
		}

		int cnt = 0;

		for (int i = 0; i < N - 2; i++) {
			for (int j = 0; j < M - 2; j++) {
				if (A[i][j] != B[i][j]) {
					for (int r = i; r < i + 3; r++) {
						for (int c = j; c < j + 3; c++) {
							A[r][c] = A[r][c] == 0 ? 1 : 0;
						}
					}
					cnt++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (A[i][j] != B[i][j]) {
					bw.write(-1 + "\n");
					bw.flush();
					return;
				}
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
  }
}