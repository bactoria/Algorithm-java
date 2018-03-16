import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _6603 {

    private static int N;
    private static int[] rottoNumber;
    private static List<Integer> result;
    private static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            sb = new StringBuilder();

            //입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            rottoNumber = new int[N];
            result = new ArrayList<>();

            if(N == 0) break;

            for (int i = 0; i < N; i++) {
                rottoNumber[i] = Integer.parseInt(st.nextToken());
            }

            //DFS
            DFS(0);

            //출력
            System.out.println(sb.toString());
        }
    }

    private static void DFS(int index){

        //로또번호 6개 다 모음.
        if(result.size() == 6){
            sb.append(result.stream()
                            .map(String::valueOf)
                            .collect(Collectors.joining(" ")))
              .append("\n");

            return ;
        }


        for (int cur = index; cur < N; cur++) {
            result.add(rottoNumber[cur]);
            DFS(cur + 1);
            result.remove(result.size() - 1);
        }
    }
}
