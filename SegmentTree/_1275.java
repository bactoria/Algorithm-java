import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());


        SegmentTree segmentTree = new SegmentTree(N);
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            segmentTree.put(i, Integer.parseInt(st.nextToken()));
        }

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            System.out.println(segmentTree.query(Math.min(x,y), Math.max(x,y)));
            segmentTree.update(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }
}

class SegmentTree {
    private final int N;
    private final int HEIGHT;
    long[] tree;

    public SegmentTree(int n) {
        HEIGHT = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        N = 1 << (HEIGHT - 1);
        tree = new long[N * 2 - 1];
    }

    public void put(int i, int value) {
        init(0, 1, N, i, value);
    }

    private void init(int index, int nodeStart, int nodeEnd, int i, int value) {

        if (nodeStart > i || nodeEnd < i) return;
        if (index >= tree.length) return;

        tree[index] += value;

        init(index * 2 + 1, nodeStart, (nodeStart + nodeEnd) / 2, i, value);
        init(index * 2 + 2, (nodeStart + nodeEnd) / 2 + 1, nodeEnd, i, value);
    }

    public long query(int queryStart, int queryEnd) {
        return process(0, 1, N, queryStart, queryEnd);
    }

    private long process(int index, int nodeStart, int nodeEnd, int queryStart, int queryEnd) {
        if (queryEnd < nodeStart) return 0;
        else if (queryStart > nodeEnd) return 0;
        else if (queryStart <= nodeStart && queryEnd >= nodeEnd) {
            return tree[index];
        } else if (nodeStart == nodeEnd) return 0;

        return process(index * 2 + 1, nodeStart, (nodeStart + nodeEnd) / 2, queryStart, queryEnd) +
                process(index * 2 + 2, (nodeStart + nodeEnd) / 2 + 1, nodeEnd, queryStart, queryEnd);
    }

    public void update(int updateNode, int value) {
        int updateIndex = (1 << (HEIGHT - 1)) - 2 + updateNode;
        long changedValue = value - tree[updateIndex];

        while (true) {
            tree[updateIndex] += changedValue;
            if(updateIndex == 0) break;
            updateIndex = updateIndex % 2 == 0 ? (updateIndex - 2) / 2 : (updateIndex - 1) / 2;
        }
    }
}



