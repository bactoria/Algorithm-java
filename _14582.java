import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14582 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int[][] team = new int[2][9];
		int count = 0;
		int[] dx = {1,-1};
		boolean ready = false;
		boolean reversed = false;
		// team[0] : ¿ì¸®ÆÀ team[1] : ÀûÆÀ
		for (int i = 0; i <= 1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 2; i++) {
				count += team[i][j] * dx[i];
				if(count>0) ready = true;
				if(count<0 && ready) reversed = true;
			}
		}
		System.out.println((reversed? "YES":"NO"));
	}
}
