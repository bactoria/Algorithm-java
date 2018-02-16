import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1932 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[][] value = new int[N][N];
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				value[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i < N; i++) {
			value[i][0] += value[i-1][0];
		}
		for (int i = 1; i < N; i++) {
			value[i][i] += value[i-1][i-1];
		}
		
		for (int i = 2; i < N; i++) {
			for (int j = 1; j < i; j++) {
				value[i][j] += max(value[i-1][j-1],value[i-1][j]);
			}
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			max = max(max,value[N-1][i]);
		}
		
		System.out.println(max);
	}

	public static int max(int i, int j) {
		if(i>j) return i;
		else return j;
	}
}

