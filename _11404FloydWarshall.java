package _11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        final int MAX_VALUE = Integer.MAX_VALUE / 2;
        final int N = Integer.parseInt(br.readLine());
        final int M = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        IntStream.range(0, N).forEach(i -> Arrays.fill(map[i], MAX_VALUE));
        IntStream.range(0, N).forEach(i -> map[i][i] = 0);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = Math.min(map[a][b], Integer.parseInt(st.nextToken()));
        }

        //플로이드 와샬
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == MAX_VALUE) map[i][j] = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            int idx = i;
            System.out.println(IntStream.range(0, N)
                    .map(j -> map[idx][j])
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" ")));
        }
    }
}
