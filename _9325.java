import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _9325 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			
			int s = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			if(n==0) {
				sb.append(s+"\n");
				continue;
			}
			
			int[][] cost = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				cost[i][0] = Integer.parseInt(st.nextToken());
				cost[i][1] = Integer.parseInt(st.nextToken());
				s += ( cost[i][0] * cost[i][1] );
			}
			
			sb.append(s+"\n");
		}
		System.out.println(sb.toString());
	}
}
