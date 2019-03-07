import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] jusa = new int[6];
    private static int[][] map;

    private static int[] dI = {0, 1, -1, 0, 0};
    private static int[] dJ = {0, 0, 0, -1, 1};

    private static int N;
    private static int M;
    private static int x;
    private static int y;

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        //map 만들기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        // 마지막 줄 (move)
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            Integer token = Integer.parseInt(st.nextToken());

            // 움직일 수 있는지 확인
            if (!moveable(y + dI[token], x + dJ[token])) continue;

            // 이동
            y += dI[token];
            x += dJ[token];

            // 주사위 굴리기
            if (token == 1) right();
            else if (token == 2) left();
            else if (token == 3) up();
            else down();

            // 맵 <-> 주사위 값 변경
            if (map[x][y] == 0) map[x][y] = jusa[5];
            else {
                jusa[5] = map[x][y];
                map[x][y] = 0;
            }
            sb.append(jusa[0]).append("\n");
        }

        System.out.println(sb.toString());
    }

    private static boolean moveable(int y, int x) {
        if (x >= 0 && y >= 0 && x < N && y < M) return true;
        else return false;
    }

    public static void right() {
        jusa = new int[]{jusa[3], jusa[1], jusa[0], jusa[5], jusa[4], jusa[2]};
    }

    public static void left() {
        jusa = new int[]{jusa[2], jusa[1], jusa[5], jusa[0], jusa[4], jusa[3]};
    }

    public static void up() {
        jusa = new int[]{jusa[4], jusa[0], jusa[2], jusa[3], jusa[5], jusa[1]};
    }

    public static void down() {
        jusa = new int[]{jusa[1], jusa[5], jusa[2], jusa[3], jusa[0], jusa[4]};
    }

}