import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1890DFSorDP {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());
        final int[][] MAP = new int[N][N];
        final long[][] DP = new long[N][N];

        DP[N-1][N-1] = 1;

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                MAP[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        for (int i = N - 1; i >= 0; i--) {

            for (int j = N - 1; j >= 0; j--) {

                if(MAP[i][j] == 0) continue;

                int nextI = i + MAP[i][j];
                int nextJ = j + MAP[i][j];

                if(nextI < N) DP[i][j] += DP[nextI][j];
                if(nextJ < N) DP[i][j] += DP[i][nextJ];

            }
        }

        System.out.println(DP[0][0]);
    }
}
