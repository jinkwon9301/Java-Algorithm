import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  static int N;
  static List<Member> list = new ArrayList<>();
  static StringTokenizer st;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    // Member-list
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int age = Integer.parseInt(st.nextToken());
      String name = st.nextToken();

      list.add(new Member(age, name));
    }

    // sort
    Collections.sort(list, (a, b) -> a.getAge() - b.getAge());
    for (Member member : list) {
      System.out.println(member.getAge() + " " + member.getName());
    }
  }

  static class Member {
    private int age;
    private String name;

    public Member(int age, String name) {
      this.age = age;
      this.name = name;
    }

    public int getAge() {
      return age;
    }

    public String getName() {
      return name;
    }
  }
}
