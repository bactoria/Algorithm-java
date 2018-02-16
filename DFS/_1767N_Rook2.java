.

package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 1.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/
 *  와 시부럴 규칙 모르곘다
 *  N-Queen은 퀸의 개수가 정해져있어서
 *  로우별로 1개씩만 되는 조건을 주면 
 *  더빨리 구할수 있다지만
 *  이거는 그렇게 visitedCol 해서 뺴줘도
 *  시간초과... 20 20 14 넣어도 안됨ㅋㅋㅋ
 *  100까지인데... 
 */
public class _1767N_Rook2 {

	private static int H;
	private static int W;
	private static int K;
	private static int[][] count;
	private static boolean[][] visited;
	private static boolean[] visitedCol;
	
	
	public static int DFS(int h, int w , int k,int startH, int startW) {
		int temp=0;
		visited[h][w] = true;
		visitedCol[h] = true;
		for (int i = 0; i < W; i++) count[h][i] ++;
		for (int i = 0; i < H; i++) count[i][w] ++;
		count[h][w]--;
		
		if(k==K-1) {
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(visited[i][j]) continue;
					if(count[i][j] == 1) temp ++;
				}
			}
			return temp%1000001;
		}

		for (int i = startH; i < H; i++) {
			if(visitedCol[i]) continue;
			for (int j = 0; j < W; j++) {
				if(i == startH && j <= startW) continue;
				if(count[i][j] == 0) temp += DFS(i,j,k+1,startH,startW);
			}
		}
		
		for (int i = 0; i < W; i++) count[h][i] --;
		for (int i = 0; i < H; i++) count[i][w] --;
		count[h][w]++;
		visited[h][w] = false;
		visitedCol[h] = false;
		return temp;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		H = Integer.parseInt(br.readLine());
		W = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = 0; i < H; i++) {
		for (int j = 0; j < W; j++) {
			count = new int[H][W];
			visited = new boolean[H][W];
			visitedCol = new boolean[H];
			result += DFS(i,j,1,i,j);
			result %= 1000001;
		}
		}
		System.out.println(result);
	}	
}