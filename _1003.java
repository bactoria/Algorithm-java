import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1003 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int TC = Integer.parseInt(br.readLine());

        final int[] N = new int[TC];
        int maxN = -1;

        for (int tc = 0; tc < TC; tc++) {
            N[tc] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN,N[tc]);
        }

        final int[][] result = new int[maxN+1][2]; //한방에 메모해놓고 프린트할꺼야!
        result[0][0] = 1;   result[0][1] = 0;
        result[1][0] = 0;   result[1][1] = 1;

        for (int tc = 2; tc <= maxN; tc++) {

            result[tc][0] = result[tc-1][0] + result[tc-2][0];
            result[tc][1] = result[tc-1][1] + result[tc-2][1];

        }

        for (int tc = 0; tc < TC; tc++) {
            System.out.println(result[N[tc]][0] + " " + result[N[tc]][1]);
        }
    }
}
