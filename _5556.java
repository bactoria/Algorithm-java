import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5556 {

    private int N;
    private int K;
    private int[][] Q;

    _5556() throws IOException {
        init();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            int fmd = findMinDist(Q[i][0], Q[i][1]);

            int result = fmd%3;
            if(result == 0) result = 3;

            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    private void init() throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        K = Integer.parseInt(br.readLine());

        Q = new int[K][2];

        for (int i = 0; i <K ; i++) {
            st = new StringTokenizer(br.readLine()," ");
            Q[i][0] = Integer.parseInt(st.nextToken());
            Q[i][1] = Integer.parseInt(st.nextToken());
        }

    }

    //동 서 남 북 중에 가장 짧은 거리 찾기.
    private int findMinDist(int II,int JJ){
        return Math.min( Math.min( II, JJ ) , Math.min( N-II+1, N-JJ+1 ) );
    }

    public static void main(String[] args) throws IOException {
        new _5556();
    }
}
