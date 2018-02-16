import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang
 * @date   : 2018. 1. 27.
 *  https://github.com/bactoria/BOJ/
 *  벽 부수고 이동하기
	DFS()
 */
public class _2206 {

	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dI = {-1,0,0,1};
	private static int[] dJ = {0,-1,1,0};
	private static int count;
	private static int N;
	private static int M;
	private static int min;

	public static int min(int a, int b) {
		return a > b? b:a;
	}
	
	public static boolean inRange(int i, int j) {
		return i>=0 && j>=0 && i<N && j<M ;
	}
	public static void DFS(int i,int j,boolean used) {
		//N,M에 도착.
		if(i == N-1 && j == M-1) {
			min = min(min,count);
		}
		//DFS도중 의미없는 DFS는 리턴시키기
		if(count > min) return;
		
		//상하좌우
		for (int k = 0; k < 4; k++) {
		int nextI = i + dI[k];
		int nextJ = j + dJ[k];
		
		if(!inRange(nextI,nextJ)) continue;
		if(visited[nextI][nextJ]) continue;
		
		if(map[nextI][nextJ] == 0) {
				visited[nextI][nextJ] = true;
				count++;
				DFS(nextI,nextJ,used);
				count--;
				visited[nextI][nextJ] = false;
			}else if((!used)) {
				visited[nextI][nextJ] = true;
				count++;
				DFS(nextI,nextJ,(!used));
				count--;
				visited[nextI][nextJ] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
		map = new int[N][M];
		visited = new boolean[N][M];
		count = 1;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		visited[0][0] = true;
		DFS(0,0,false);
		
		if(min == Integer.MAX_VALUE) min = -1;
		System.out.println(min);
	}

}
