package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _2583Square {

	private BufferedReader br;
	private StringTokenizer st;
	private int m, n, k, value;
	private int[][] array;
	private int[] dx = { -1, 0, 0, 1 }, dy = { 0, -1, 1, 0 };
	private ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		_2583Square main = new _2583Square();
		main.start();
	}

	private boolean inRange(int i, int j) {
		return i >= 0 && j >= 0 && i < m && j < n;
	}

	private void DFS(int i, int j) {
		array[i][j] = 1;
		value++;
		for (int k = 0; k < 4; k++) {
			int nextI = i + dx[k];
			int nextJ = j + dy[k];
			if (!inRange(nextI, nextJ)) continue;
			if (array[nextI][nextJ] == 1) continue;
			DFS(nextI, nextJ);
		}
	}

	private void start() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); // 세로
		n = Integer.parseInt(st.nextToken()); // 가로
		k = Integer.parseInt(st.nextToken());
		array = new int[m][n];
		int count = 0;

		while(k-->0) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()); // 0
			int y1 = Integer.parseInt(st.nextToken()); // 2
			int x2 = Integer.parseInt(st.nextToken()); // 4
			int y2 = Integer.parseInt(st.nextToken()); // 4

			for (int j = y1; j < y2; j++) { // 세로
				for (int j2 = x1; j2 < x2; j2++) { // 가로
					array[j][j2] = 1;
				}
			}
		}

		for (int j = 0; j < m; j++) {
			for (int j2 = 0; j2 < n; j2++) {
				if (array[j][j2] == 1)	continue;  //0일때 들어가야대
				value = 0;
				DFS(j, j2);
				count++;
				list.add(value);

			}
		}
		Collections.sort(list);


		System.out.println(count);

		for(Integer i :list) {
			System.out.print(i+" ");
		}
		
/*		String result = list.stream().map(String::valueOf).collect(Collectors.joining(" "));
		System.out.println(result);
*/
	}
}