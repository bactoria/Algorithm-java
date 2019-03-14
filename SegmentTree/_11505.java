import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        Q += Integer.parseInt(st.nextToken());

        SegmentTree segmentTree = new SegmentTree(N);

        for (int i = 0; i < N; i++) {
            segmentTree.put(i, Integer.parseInt(br.readLine()));
        }

        segmentTree.putParents();

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sub = Integer.parseInt(st.nextToken());

            if (sub == 1) { // update
                int index = Integer.parseInt(st.nextToken());
                int value = Integer.parseInt(st.nextToken());

                segmentTree.update(index, value);
            } else { // print
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                sb.append(segmentTree.query(from, to)).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}

class SegmentTree {
    private final int HEIGHT;
    private final int S;
    long[] tree;

    public SegmentTree(int n) {
        HEIGHT = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        S = 1 << (HEIGHT - 1);
        tree = new long[2 * S];
        Arrays.fill(tree, 1);
    }

    public void update(int index, int value) {

        index += S - 1;
        tree[index] = value;
        index /= 2;

        while (index > 0) {
            tree[index] = tree[index * 2] * tree[index * 2 + 1];
            tree[index] %= 1000000007;
            index /= 2;
        }
    }

    public void put(int i, int value) {
        i += S;
        tree[i] *= value;
    }

    public long query(int queryStart, int queryEnd) {
        return process(1, 1, S, queryStart, queryEnd);
    }

    private long process(int index, int l, int r, final int FROM, final int TO) {

        if (index >= tree.length) return 1;

        if (l > TO || r < FROM) return 1;
        else if (l >= FROM && r <= TO) return tree[index];

        int mid = (r + l) / 2;
        return process(index * 2, l, mid, FROM, TO) * process(index * 2 + 1, mid + 1, r, FROM, TO) % 1000000007;

    }

    public void putParents() {
        for (int i = S - 1; i >= 1; i--) {
            tree[i] = tree[i * 2] * tree[i * 2 + 1] % 1000000007;
        }
    }
}