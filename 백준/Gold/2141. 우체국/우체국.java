import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    //마을 관련 클래스
    static class House implements Comparable<House>{
        long pos, val;
        public House(long pos, long val){
            this.pos = pos;
            this.val = val;
        }
        //마을 위치 기준 오름차순 정렬 기준
        @Override
        public int compareTo(House o) {
            return (int) (this.pos - o.pos);
        }
    }
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        //마을 정보 저장 리스트
        List<House> houseList = new ArrayList<>();
        long sum = 0;
        //마을 정보들 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            long pos  = Long.parseLong(st.nextToken());
            long val = Long.parseLong(st.nextToken());
            houseList.add(new House(pos, val));
            sum += val;	//총 인원 구하기
        }
        Collections.sort(houseList);	//마을 위치 기준 오름차순 정렬
        long result = 0;
        //가장 먼저 중간값보다 크거나 같은 마을 탐색
        for(int i=0;i<N;i++){
            result += houseList.get(i).val;
            if((sum + 1)/2 <= result){	//(sum+1)/2 : 중간값
                bw.write(String.valueOf(houseList.get(i).pos));
                break;
            }
        }
        bw.flush();	//결과 출력
        bw.close();
        br.close();
    }
}