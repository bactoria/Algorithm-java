import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : PC
 * @date   : 2018. 1. 26. 
 * 문제           : 적록색약
 * 남길 말       : i랑 j 구분 잘하자.
 * 
	// R : 82 G : 71 B : 66
 */
public class _10026RGB {
	static class Node {
		int i;
		int j;

		Node(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	private static int N;

	public static boolean inRange(int i, int j) {
		return i>=0 && j>=0 && i<N && j<N;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[][] map1 = new int[N][N];
		int[][] map2 = new int[N][N];
		boolean[][] visited1 = new boolean[N][N];
		boolean[][] visited2 = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map1[i][j] = c[j];
				map2[i][j] = c[j];
				if(c[j] == 'G') map2[i][j] += 11;
			}
		}
		Queue<Node> q = new LinkedList<Node>();

		int[] di = { -1, 0, 0, 1 };
		int[] dj = { 0, -1, 1, 0 };
		int count1 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited1[i][j]) continue;
				visited1[i][j] = true;
				count1++;
				q.add(new Node(i, j));
				int curC = map1[i][j];
				while (!q.isEmpty()) {
					Node curN = q.poll();
					int curI = curN.i;
					int curJ = curN.j;

					for (int k = 0; k < 4; k++) {
						int nextI = curI + di[k];
						int nextJ = curJ + dj[k];
						if(!inRange(nextI,nextJ)) continue;
						if (map1[nextI][nextJ] != curC) continue;
						if (visited1[nextI][nextJ]) continue;
						
						visited1[nextI][nextJ] = true;
						q.add(new Node(nextI, nextJ));
					}
				}
			}
		}

		int count2 = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited2[i][j]) continue;
				count2++;
				visited2[i][j] = true;
				q.add(new Node(i, j));
				int curC = map2[i][j];
				while (!q.isEmpty()) {
					Node curN = q.poll();
					int curI = curN.i;
					int curJ = curN.j;

					for (int k = 0; k < 4; k++) {
						int nextI = curI + di[k];
						int nextJ = curJ + dj[k];
						if(!inRange(nextI,nextJ)) continue;
						if (map2[nextI][nextJ] != curC) continue;
						if (visited2[nextI][nextJ]) continue;
						
						visited2[nextI][nextJ] = true;
						q.add(new Node(nextI, nextJ));
					}
				}
			}
		}

		System.out.println(count1 + " " + count2);
	}

}
