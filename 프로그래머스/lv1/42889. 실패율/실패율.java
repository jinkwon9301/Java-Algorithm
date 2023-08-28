import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] fail_count = new int[N + 2];
        double[][] failRate = new double[N + 1][2];
        int size = stages.length;

        for (int stage : stages) {
          fail_count[stage]++;
        }

        failRate[0][0] = -1;
        for (int i = 1; i < failRate.length; i++) {
          failRate[i][0] = (fail_count[i] == 0) ? 0 : (double) fail_count[i] / size;
          failRate[i][1] = i;
          size -= fail_count[i];
        }

        Arrays.sort(failRate, new Comparator<double[]>() {
          @Override
          public int compare(double[] o1, double[] o2) {
            return Double.compare(o2[0], o1[0]);
          }
        });

        int[] result = new int[N];
        for (int i = 0; i < result.length; i++) {
          result[i] = (int) failRate[i][1];
        }

        return result;
    }
}