import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visited = new boolean[1001][1001];

        int S = Integer.parseInt(br.readLine());

        int minValue = Integer.MAX_VALUE;

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(2, 2, 1));

        while (!queue.isEmpty()) {

            Node cur = queue.poll();


            int curS = cur.S;
            int curTime = cur.time;
            int curCopyData = cur.copyData;

            if(curS < 0) continue;
            if (curS > S) continue;
            if (visited[curS][curCopyData]) continue;
            if (curTime > minValue) continue;
            if (curS == S) minValue = Math.min(minValue, curTime);

            visited[curS][curCopyData] = true;

            queue.add(new Node(curS, curTime + 1, curS)); //copy
            queue.add(new Node(curS + curCopyData, curTime + 1, curCopyData)); // paste
            queue.add(new Node(curS - 1, curTime + 1, curCopyData)); // backspace
        }

        System.out.println(minValue);

    }
}

class Node {
    int S;
    int time;
    int copyData;

    public Node(int s, int time, int copyData) {
        S = s;
        this.time = time;
        this.copyData = copyData;
    }

}
