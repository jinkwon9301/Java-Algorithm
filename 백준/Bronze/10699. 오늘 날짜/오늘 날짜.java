import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {

  public static void main(String[] args) throws IOException {
    // 입력 값 받기
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 현재 날짜 가져오기
    LocalDate currentDate = LocalDate.now();

    // 날짜 포맷 지정
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 포맷에 맞게 출력
    String formattedDate = currentDate.format(formatter);
    System.out.println(formattedDate);
  }
}
