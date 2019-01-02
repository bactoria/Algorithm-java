import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.process();
    }

}

final class Solution {

    private int[][] map;
    private int N;

    public Solution() throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public void process() {

        int[] result = DC(0, 0, N);

        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }

    private int[] DC(int x, int y, int n) {

        int[] result = {0, 0, 0};
        if (n == 1) {
            if (map[x][y] == -1) result[0] = 1;
            else if (map[x][y] == 0) result[1] = 1;
            else result[2] = 1;
        } else {
            int nextLen = n / 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int[] subResult = DC(x + i * nextLen, y + j * nextLen, nextLen);
                    result[0] += subResult[0];
                    result[1] += subResult[1];
                    result[2] += subResult[2];
                }
            }

            if (result[2] + result[1] == 0) result[0] = 1;
            if (result[0] + result[2] == 0) result[1] = 1;
            if (result[0] + result[1] == 0) result[2] = 1;

        }
        return result;
    }

}
