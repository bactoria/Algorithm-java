import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 11.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/1051
 *  
 */
public class _1051 {

	private static int N;
	private static int M;
	private static char[][] map;
	private static int maxLen;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		maxLen = 1;
		
		for (int i = 0; i < N; i++) 	map[i] = br.readLine().toCharArray();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
					findResult(i,j,map[i][j]);
			}
		}
		
		System.out.println(maxLen * maxLen);
	}

	
	
	private static void findResult(int i, int j, int value) {
		int change = 0;

		while(true) {
			change++;
			int newI = i+change;
			int newJ = j-change;
			
			if(!inRange(newI,newJ)) break;
			if(value != map[newI][newJ]) continue;
			if(value != map[i][newJ]) continue;
			if(value != map[newI][j]) continue;
			
			maxLen = Math.max(maxLen , change+1 );
		}
	}
	
	private static boolean inRange(int i, int j) {
		return i >= 0  &&  j >= 0  &&  i < N  &&  j < M;
	}
}