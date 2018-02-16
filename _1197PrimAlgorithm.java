import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 31.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/
 *  틀렸습니다. 왜틀렸지................
 *  
 */
public class _1197PrimAlgorithm {

	static class Node implements Comparable<Node> {
		int next;
		int value;

		Node(int next, int value) {
			this.next = next;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return value - o.value;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		final int V = Integer.parseInt(st.nextToken());
		final int E = Integer.parseInt(st.nextToken());
		int[][] graph = new int[V + 1][V + 1];
		long count = 0;
		boolean[] visited = new boolean[V + 1];
		int remain = V;
		
		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int tempA = Integer.parseInt(st.nextToken());
			int tempB = Integer.parseInt(st.nextToken());
			int tempV = Integer.parseInt(st.nextToken());

			graph[tempA][tempB] = tempV;
			graph[tempB][tempA] = tempV;
		}

		Queue<Node> q = new PriorityQueue<Node>();

		//Vertex 1을 추가해준다.
		remain--;
		visited[1] = true;
		for (int j = 1; j <= V; j++) {
			if (graph[1][j] == 0) continue;
			q.add(new Node(j, graph[1][j]));
		}
		
		//비용이 작은 것부터 하나씩 뺀다.
		while (remain != 0) {
			Node cur = q.poll();
			int curV = cur.next;
			if(visited[curV]) continue;
			remain--;
			visited[curV] = true;
			count += cur.value;
			for (int next = 1; next <= V; next++) {
				if (graph[curV][next] == 0) continue;
				if (visited[next]) continue; //cycle 없애기
				q.add(new Node(next, graph[curV][next]));
			}
		}
		System.out.println(count);
	}
}