/*
https://www.acmicpc.net/problem/1238
다익스트라
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int X = Integer.parseInt(st.nextToken());

        final int[][] cost = new int[N + 1][N + 1];

        final int[] dist1 = new int[N + 1];
        final int[] dist2 = new int[N + 1];
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        dist1[X] = 0;
        dist2[X] = 0;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cost[x][y] = Integer.parseInt(st.nextToken());

        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int j = 1; j <= N; j++) {

                if (cost[j][x] == 0) continue;

                if (dist1[j] > dist1[x] + cost[j][x]) {
                    dist1[j] = dist1[x] + cost[j][x];
                    queue.add(j);
                }
            }
        }

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(X);

        while (!queue2.isEmpty()) {
            int x = queue2.poll();

            for (int j = 1; j <= N; j++) {

                if (cost[x][j] == 0) continue;

                if (dist2[j] > dist2[x] + cost[x][j]) {
                    dist2[j] = dist2[x] + cost[x][j];
                    queue2.add(j);
                }
            }
        }

        int result = 0;

        for (int i = 1; i <= N; i++) {
            if (dist1[i] == Integer.MAX_VALUE) continue;
            if (dist2[i] == Integer.MAX_VALUE) continue;
            result = Math.max(result, dist1[i] + dist2[i]);
        }

        System.out.println(result);
    }
}
