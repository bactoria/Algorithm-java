import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] DP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        DP = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            String[] st = br.readLine().split(" ");
            T[i] = Integer.parseInt(st[0]);
            P[i] = Integer.parseInt(st[1]);
        }

        for (int i = 1; i <= N; i++) {

            int target = i + T[i];
            DP[i] = Math.max(DP[i], DP[i - 1]);

            if (target > N+1) continue;
            DP[target] = Math.max(DP[target], DP[i] + P[i]);
        }

        DP[N + 1] = Math.max(DP[N + 1], DP[N]);

        System.out.println(DP[N+1]);
    }
}
