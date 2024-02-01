import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int result = -2147483648;
	static ArrayList<Integer> nums = new ArrayList<>();
	static ArrayList<Character> operator = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String input = br.readLine();

		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) nums.add(Character.getNumericValue(input.charAt(i)));
			else operator.add(input.charAt(i));
		}

		find(0, nums.get(0));
		System.out.println(result);
	}

	private static void find(int idx, int total) {
		// 연산 종료 시점
		if (idx == operator.size()) {
			result = Math.max(result, total);
			return;
		}
		// 괄호 쳐서 연산 후 넘어가기
		// (8 * 3) + 5
		// f1 : calculate(8, 3, *)
		// f2 : calculate(24, 5, +)
		int cal = calculate(total, nums.get(idx + 1), operator.get(idx));
		// f1 : idx = 0, cal = 24
		// f2 : idx = 1, cal = 29
		find(idx + 1, cal);

		// 괄호 안치고 넘어가기
		// 8 * (3 + 5)
		// f2 : idx = 1, cal = 29 -> num이 부족 -> x
		// f1 : idx = 0, cal = 24
		//      (idx + 2 <= nums.size()) true
        //		-> calculate(8, calcultate(3, 5, +), *)
		if (idx + 2 <= nums.size() - 1) {
			cal = calculate(total, calculate(nums.get(idx + 1), nums.get(idx + 2), operator.get(idx + 1)), operator.get(idx));
			find(idx + 2, cal);
		}
	}

	private static int calculate(int a, int b, char oper) {
			if (oper == '-') return a - b;
			else if (oper == '+') return a + b;
			else return a * b;
	}
}