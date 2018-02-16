import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _1520 {
	static class Node {
		private Integer value;

		@Override
		public String toString() {
			return "Node [value=" + value + ", i=" + i + ", j=" + j + "]";
		}

		private int i;
		private int j;

		Node(int value, int i, int j) {
			this.value = value;
			this.i = i;
			this.j = j;
		}

		public int getI() {
			return i;
		}

		public int getValue() {
			return value;
		}

		public int getJ() {
			return j;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] map = new int[M][N];
		Node[] node = new Node[M * N];
		int[][] dp = new int[M][N];
		int tempC = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				node[tempC++] = new Node(map[i][j], i, j);
			}
		}

		Arrays.sort(node, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub

				if (o1.getValue() > o2.getValue())
					return -1;
				else if (o1.getValue() == o2.getValue())
					return 0;
				else
					return 1;
			}
		});

		dp[0][0] = 1;
			for (int j = 0; j < N*M ; j++) {
				int tempI = node[j].getI();
				int tempJ = node[j].getJ();
			
				if (tempI > 0) {
					if (map[tempI][tempJ] < map[tempI - 1][tempJ]) {
						dp[tempI][tempJ] += dp[tempI - 1][tempJ];
					}
				}
				if (tempI < M - 1) {
					if (map[tempI][tempJ] < map[tempI + 1][tempJ]) {
						dp[tempI][tempJ] += dp[tempI + 1][tempJ];
					}
				}
				if (tempJ > 0) {
					if (map[tempI][tempJ] < map[tempI][tempJ - 1]) {
						dp[tempI][tempJ] += dp[tempI][tempJ - 1];
					}
				}
				if (tempJ < N - 1) {
					if (map[tempI][tempJ] < map[tempI][tempJ + 1]) {
						dp[tempI][tempJ] += dp[tempI][tempJ + 1];
					}
				}
		}
		System.out.println(dp[M-1][N-1]);
	}

}
