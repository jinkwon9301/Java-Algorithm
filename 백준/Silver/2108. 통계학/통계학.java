import java.util.*;
import java.io.*;

class Main {
  static int N, sum, mean, median, mode, range, max_frequency, max_frequency_index;
  static int[] arr;
  static int[] frequency_plus = new int[4001];
  static int[] frequency_minus = new int[4001];

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(br.readLine());
      sum += arr[i];
      if (arr[i] >= 0) frequency_plus[arr[i]]++;
      else frequency_minus[Math.abs(arr[i])]++;
    }

    mean = (int) Math.round((double) sum / N);
    Arrays.sort(arr);
    median = arr[N / 2];
    range = arr[N - 1] - arr[0];

    for (int i = 0; i < 4001; i++) {
      if (frequency_minus[i] > max_frequency) max_frequency = frequency_minus[i];
      if (frequency_plus[i] > max_frequency) max_frequency = frequency_plus[i];
    }

    for (int i = 4000; i >= 0; i--) {
      if (frequency_minus[i] == max_frequency) {
        mode = i * -1;
        max_frequency_index++;
        if (max_frequency_index == 2) {
          break;
        }
      }
    }

    if (max_frequency_index != 2) {
      for (int i = 0; i < 4001; i++) {
        if (frequency_plus[i] == max_frequency) {
          mode = i;
          max_frequency_index++;
          if (max_frequency_index == 2) {
            break;
          }
        }
      }
    }

    System.out.println(mean);
    System.out.println(median);
    System.out.println(mode);
    System.out.println(range);
  }
}

