import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int HEIGHT;
    static int[] segmentTree;
    static int LEFT;
    static int RIGHT;
    static int[] values;
    static int leafStart;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            HEIGHT = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
            leafStart = (int) (Math.pow(2, HEIGHT - 1) - 1);
            int leafEnd = leafStart + N - 1;

            segmentTree = new int[leafEnd + 1];

            values = new int[N + 1];
            values[0] = Integer.MAX_VALUE;
            for (int i = 1; i <= N; i++) values[i] = Integer.parseInt(st.nextToken());


            for (int i = 1; i <= N; i++) {
                init(0, 1, leafStart + 1, i);
            }

            System.out.println(process(1, N));
        }
    }

    private static void init(int index, int start, int end, int leaf) {
        segmentTree[index] = values[segmentTree[index]] > values[leaf] ? leaf : segmentTree[index];

        if (start == end) segmentTree[index] = leaf;
        else if (leaf <= (start + end) / 2) init(index * 2 + 1, start, (start + end) / 2, leaf); // 좌
        else init(index * 2 + 2, (start + end) / 2 + 1, end, leaf); // 우
    }

    private static long process(int left, int right) {
        if (left > right) return 0;
        else if (left == right) return values[left];

        LEFT = left;
        RIGHT = right;
        int minValue = findMin(0, 1, leafStart + 1);
        return max((long) (right - left + 1) * values[minValue], process(left, minValue - 1), process(minValue + 1, right));
    }

    private static int findMin(int index, int start, int end) {
        if (start > RIGHT || LEFT > end) return 0;
        else if (LEFT <= start && RIGHT >= end) return segmentTree[index];
        int leftChild = findMin(index * 2 + 1, start, (start + end) / 2);
        int rightChild = findMin(index * 2 + 2, (start + end) / 2 + 1, end);
        return values[leftChild] > values[rightChild] ? rightChild : leftChild;
    }

    private static long max(long a, long b, long c) {
        return a > b ? (a > c ? a : c) : b > c ? b : c;
    }
}



