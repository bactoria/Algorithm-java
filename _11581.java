import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11581 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int N = Integer.parseInt(br.readLine());

		int[][] map = new int[N + 1][N + 1];
		boolean[] visited = new boolean[N + 1];
		int[] len = new int[N + 1];

		for (int i = 1; i <= N-1; i++) {
			len[i] = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < len[i]; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
			Queue<Integer> q = new LinkedList<Integer>();

			visited[1] = true;
			q.add(1);

			while (!q.isEmpty()) {

				int curN = q.poll();
				for (int j = 0; j < len[curN]; j++) {
					int nextN = map[curN][j];
					if (nextN != N) {
						if (visited[nextN]) {
							System.out.println("CYCLE");
							return;
						}
						
						visited[nextN] = true;
						q.add(nextN);
					}
				}
			}
		System.out.println("NO CYCLE");
	}

}
