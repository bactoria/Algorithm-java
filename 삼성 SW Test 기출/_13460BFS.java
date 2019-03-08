import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        solution.init();
        System.out.println(solution.process());
    }

}

final class Solution {

    private int[] dI = {0, 1, 0, -1};
    private int[] dJ = {-1, 0, 1, 0};

    private char map[][];
    private int N;
    private int M;
    private int Rx1;
    private int Ry1;
    private int Bx1;
    private int By1;

    public void init() throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'R') {
                    map[i][j] = '.';
                    Rx1 = j;
                    Ry1 = i;
                } else if (map[i][j] == 'B') {
                    map[i][j] = '.';
                    Bx1 = j;
                    By1 = i;
                }
            }
        }
    }

    public int process() {

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(1, Bx1, By1, Rx1, Ry1,-1));

        while (!queue.isEmpty()) {

            Node node = queue.poll();

            if (node.count > 10) continue;

            for (int i = 0; i < 4; i++) {
                int visited = node.curI & i;
                if(visited == 1 && node.curI != -1) continue;

                int Rx = node.Rx;
                int Ry = node.Ry;
                int Bx = node.Bx;
                int By = node.By;

                boolean arrivedR = false;
                boolean arrivedB = false;

                boolean RisLeft = false;
                boolean RisUp = false;

                if (Rx < Bx) RisLeft = true;
                if (Ry < By) RisUp = true;

                while ( visible(Rx + dI[i], Ry + dJ[i]) ) {
                    Rx += dI[i];
                    Ry += dJ[i];

                    if (map[Ry][Rx] == 'O') {
                        arrivedR = true;
                        break;
                    }

                }

                while ( visible(Bx + dI[i], By + dJ[i]) ) {
                    Bx += dI[i];
                    By += dJ[i];

                    if (map[By][Bx] == 'O') {
                        arrivedB = true;
                        break;
                    }
                }

                if (Rx == node.Rx && Ry == node.Ry && Bx == node.Bx && By == node.By) continue;

                if (arrivedR) {
                    if (arrivedB) {
                        continue;
                    } else {
                        return node.count;
                    }
                } else if (arrivedB) {
                    continue;
                }

                if (Rx == Bx && Ry == By) {
                    if (i == 0) {
                        if (RisUp) By += 1;
                        else Ry += 1;
                    } else if (i == 1) {
                        if (RisLeft) Rx -= 1;
                        else Bx -= 1;
                    } else if (i == 2) {
                        if (RisUp) Ry -= 1;
                        else By -= 1;
                    } else {
                        if (RisLeft) Bx += 1;
                        else Rx += 1;
                    }
                }

                queue.add(new Node(node.count + 1, Bx, By, Rx, Ry, i));
            }
        }
        return -1;
    }

    private boolean visible(int x, int y) {
        if (map[y][x] == '#') return false;
        else return true;
    }

}

class Node {
    int count;
    int Bx;
    int By;
    int Rx;
    int Ry;
    int curI;

    public Node(int count, int bx, int by, int rx, int ry, int curI) {
        this.count = count;
        Bx = bx;
        By = by;
        Rx = rx;
        Ry = ry;
        this.curI = curI;
    }
}