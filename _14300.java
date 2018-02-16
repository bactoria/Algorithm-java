import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14300 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		final int MAX = 5;
		int[][] info = {{1,1,0},{0,0,1}};
		int[][] map = new int[MAX][MAX];
		
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				int subInfo = 0; 
				if(i%3 == 2) subInfo = 1;
				map[i][j] = info[subInfo][j%3];
			}
		}
		
		final int TT = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= TT; tt++) {
			st = new StringTokenizer(br.readLine());
			int curI = Integer.parseInt(st.nextToken());
			int curJ = Integer.parseInt(st.nextToken());

			int count = 0;
			for (int i = 0; i < curI; i++) {
				for (int j = 0; j < curJ; j++) {
					if(map[i][j]==1) count++;
				}
			}
			sb.append("Case #"+tt+": "+count+"\n");
		}
		System.out.println(sb.toString());
	}
}
