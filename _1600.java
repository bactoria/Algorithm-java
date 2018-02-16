import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class _1600 {

	public static void main(final String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.solve();
	}

}

class Solution {

	public void solve() {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		int[][] info = new int[H][W];
		int[][][] dist = new int[H][W][K + 1];
		int[] dx = { -1, 0, 0, 1 };
		int[] dy = { 0, -1, 1, 0 };
		int[] horseX = { -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] horseY = { -1, 1, -2, 2, -2, 2, -1, 1 };
		int min = 44444;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				info[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				for (int k = 0; k <= K; k++) {
					dist[i][j][k] = 44444;
				}
			}
		}

		Queue<Node> q = new LinkedList<Node>();
		for (int k = 0; k <= K; k++) {
			dist[0][0][k] = 0;
		}

		q.add(new Node(0, 0, 0));

		while (!q.isEmpty()) {
			Node now = q.poll();

			for (int i = 0; i < 4; i++) {
				try {
					if (info[now.x + dx[i]][now.y + dy[i]] == 1)
						continue;
					if (dist[now.x + dx[i]][now.y + dy[i]][now.k] <= dist[now.x][now.y][now.k] + 1)
						continue;

					q.add(new Node(now.x + dx[i], now.y + dy[i], now.k));
					dist[now.x + dx[i]][now.y + dy[i]][now.k] = dist[now.x][now.y][now.k] + 1;

				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}

			for (int i = 0; i < 8; i++) {
				try {
					if (now.k == K)
						continue;
					if (info[now.x + horseX[i]][now.y + horseY[i]] == 1)
						continue;
					if (dist[now.x + horseX[i]][now.y + horseY[i]][now.k + 1] <= dist[now.x][now.y][now.k] + 1)
						continue;

					q.add(new Node(now.x + horseX[i], now.y + horseY[i], now.k + 1));
					dist[now.x + horseX[i]][now.y + horseY[i]][now.k + 1] = dist[now.x][now.y][now.k] + 1;

				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}

		}

		for (int k = 0; k <= K; k++) {
			min = Math.min(min, dist[H - 1][W - 1][k]);
		}
		if (min == 44444) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static class Node {
		int x, y, k;

		Node(int x, int y, int k) {
			this.x = x;
			this.y = y;
			this.k = k;
		}

	}

}
