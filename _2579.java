import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2579 {
	
	public static int max (int a, int b) {
		return (a > b ? a : b) ;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[] cost = new int[N];
		int[][] record = new int[N][3]; 
		
		for (int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		record[0][1] = cost[0];
		
		
		for (int i = 1; i < N; i++) {
			record[i][0] = max(record[i-1][2],record[i-1][1]);
			record[i][1] = record[i-1][0]+cost[i];
			record[i][2] = record[i-1][1]+cost[i];
		}
		System.out.println(max(record[N-1][1],record[N-1][2]));
	}
}