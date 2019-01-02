import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        new Solution();
    }

}

final class Solution {

    int T, N;
    Node[] nodes;

    public Solution() throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());

            nodes = new Node[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i);
            }

            for (int i = 0; i < N; i++) {

                Node cur = nodes[i];

                for (int j = 0; j < i; j++) {

                    Node target = nodes[j];
                    if (isConnected(cur, target)) {
                        nodes[findRoot(j)].parent = cur.parent;
                    }
                }
            }

            Set<Integer> set = new HashSet<>();

            for (Node node : nodes) {
                int asd = findRoot(node.parent);
                set.add(asd);
            }
            System.out.println(set.size());
        }
    }

    private boolean isConnected(Node cur, Node target) {
        if (cur.radius + target.radius >= Math.sqrt((cur.x - target.x) * (cur.x - target.x) + (cur.y - target.y) * (cur.y - target.y))) {
            return true;
        } else {
            return false;
        }
    }

    private int findRoot(int index) {
        Node curNode = nodes[index];

        if (curNode.parent != index) {
            return findRoot(curNode.parent);
        }else return curNode.parent;
    }

}

final class Node {
    int x;
    int y;
    int radius;
    int parent;

    public Node(int x, int y, int radius, int parent) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.parent = parent;
    }

}