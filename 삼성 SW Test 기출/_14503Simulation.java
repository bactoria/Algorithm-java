import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] map;
    static boolean[][] visited;
    static int clear = 1;
    static int r;
    static int c;
    static int d;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] st = br.readLine().split(" ");

        final int N = Integer.parseInt(st[0]);
        final int M = Integer.parseInt(st[1]);

        map = new int[N][M];
        visited = new boolean[N][M];

        st = br.readLine().split(" ");

        r = Integer.parseInt(st[0]);
        c = Integer.parseInt(st[1]);
        d = Integer.parseInt(st[2]);


        for (int i = 0; i < N; i++) {
            st = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st[j]);
            }
        }

        boolean moved = true;
        visited[r][c] = true;

        while (moved) {
            moved = false;
            for (int i = 1; i <= 4; i++) {

                int curD = d - i >= 0 ? d - i : d - i + 4;

                if (moveable(r, c, curD)) {
                    move(curD);
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                if (d == 0) {
                    if (map[r+1][c] == 0) {
                        r++;
                        moved = true;
                    }
                } else if (d == 1) {
                    if (map[r][c-1] == 0) {
                        c--;
                        moved = true;
                    }
                } else if (d == 2) {
                    if (map[r - 1][c] == 0) {
                        r--;
                        moved = true;
                    }
                } else {
                    if (map[r][c + 1] == 0) {
                        c++;
                        moved = true;
                    }
                }
            }

            if(!moved) {
                System.out.println(clear);

                return;
            }

        }


    }

    private static void move(int curD) {
        if (curD == 0) r--;
        else if (curD == 1) c++;
        else if (curD == 2) r++;
        else c--;

        visited[r][c] = true;
        clear++;
        d = curD;
    }

    private static boolean moveable(int r, int c, int d) {
        if (d == 0) r--;
        else if (d == 1) c++;
        else if (d == 2) r++;
        else c--;

        if (map[r][c] == 1) return false;
        if (visited[r][c]) return false;

        return true;
    }

}