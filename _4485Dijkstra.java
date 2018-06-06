import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
* 우선순위큐를 쓴다.
*
* distence 배열에 최저 방문횟수를 저장한다.
*
* 큐에 꺼낼때마다 distence 보다 크다면 무시한다. 이미 적은게 있기때문
*
* 그 덕분에 큐에는 그냥 막 넣어도된다. 체크는 위에서 한다.
*
* 꺼낼때도 우선순위에서 밀려났던 큰 distence가 있을 수 있기 때문에 distence배열보다 높은값이면 무시한다.
*
* 그 경로는 이미 더 작은 값으로 검색했기 때문이다
* */

class Node implements Comparable<Node> {
    int nodeI;
    int nodeJ;
    int distence;

    public Node(int nodeI, int nodeJ, int distence) {
        this.nodeI = nodeI;
        this.nodeJ = nodeJ;
        this.distence = distence;
    }

    @Override
    public int compareTo(Node o) {
        return this.distence - o.distence;
    }
}

public class _4485Dijkstra {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = 0;

        final int DI[] = {0,0,-1,1};
        final int DJ[] = {-1,1,0,0};

        while(true) {
            TC++;
            final int n = Integer.parseInt(br.readLine());
            final int[][] map = new int[n][n];
            int result = Integer.MIN_VALUE;

            //Escape
            if(n == 0)  break;

            //Inicialize
            for (int i = 0; i < n; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            final int[][] distence = new int[n][n];

            //큰값으로 초기화
            for (int i = 0; i < n; i++) {
                Arrays.fill(distence[i],Integer.MAX_VALUE);
            }

            distence[0][0] = map[0][0];

            PriorityQueue<Node> pq = new PriorityQueue<>();

            pq.add(new Node(0,0,distence[0][0]));

            while(!pq.isEmpty()) {

                Node cur = pq.poll();

                int curI = cur.nodeI;
                int curJ = cur.nodeJ;
                int curDistence = cur.distence;

                if(curI == n-1 && curJ == n-1) {
                    result = curDistence;
                    break;
                }

                if(curDistence > distence[curI][curJ]) continue;

                for (int i = 0; i < 4; i++) {

                    int nextI = curI + DI[i];
                    int nextJ = curJ + DJ[i];

                    if(nextI < 0 || nextI >= n || nextJ < 0 || nextJ >= n) continue;

                    int nextDistence = curDistence + map[nextI][nextJ];

                    if(distence[nextI][nextJ] <= nextDistence) continue;

                    distence[nextI][nextJ] = nextDistence;

                    pq.add(new Node(nextI,nextJ,nextDistence));

                }

            }

            sb.append("Problem " + TC + ": " + result + "\n");
        }

        System.out.println(sb.toString());

    }

}
