package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  Clam 

 */
public class _14870Shellfish {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		int[][] dp = new int[N+1][N+1];
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		long count = 0;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[1][1] = map[1][1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				count += dp[i][j];
			}
		}
		sb.append(count+"\n");
		for (int z = 1; z <= N; z++) {
			st = new StringTokenizer(br.readLine());
			int c = st.nextToken().charAt(0) == 'U' ? 1 : -1 ;
			int tempI = Integer.parseInt(st.nextToken()) ;
			int tempJ = Integer.parseInt(st.nextToken()) ;

			map[tempI][tempJ] += c ;
		
			for (int i = tempI; i <= N; i++) {
				boolean changed = false;
				for (int j = tempJ; j <= N; j++) {
					int tempDP = dp[i][j];
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + map[i][j];
					if(dp[i][j] != tempDP) {
						count += dp[i][j] - tempDP;
						changed = true ;
					}
				}
				if(!changed) break;
			}
			sb.append(count+"\n");
		}
		System.out.println(sb.toString());
	}
}
