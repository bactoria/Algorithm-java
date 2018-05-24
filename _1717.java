import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1717 {

    private static int[] root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        root = new int[N+1];

        for (int i = 1; i <= N ; i++) {
            root[i] = i;
        }

        for(int i = 0; i < M ; i ++) {
            st = new StringTokenizer(br.readLine());

            int query = Integer.parseInt(st.nextToken());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            switch(query) {

                case 0:
                    union(first, second);
                    break;


                case 1:
                    if(find(first) == find(second) ) {
                        sb.append("YES\n");
                    }else sb.append("NO\n");
                    break;
            }
        }
        System.out.println(sb.toString());
    }

    private static void union(int first, int second) {

        if( first == second) return;

        int rootFirst = find(first);
        int rootSecond = find(second);

        root[rootFirst] = rootSecond;
    }

    private static int find (int x) {

        if(x == root[x]) return x;

        return root[x] = find(root[x]);
    }
}
