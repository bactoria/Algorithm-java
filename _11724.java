import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11724 {

	private static boolean[][] graph;
	private static boolean[] visited;
	private static int N;

	
	public static void DFS(int i) {
		visited[i] = true;

		for (int j = 1; j <= N; j++) {
			if (!graph[i][j]) continue;
			if (visited[j])   continue;
			DFS(j);
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());

		int count = 0;
		graph = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int tempA = Integer.parseInt(st.nextToken());
			int tempB = Integer.parseInt(st.nextToken());

			graph[tempA][tempB] = true;
			graph[tempB][tempA] = true;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);
	}

}
