import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		int[][] rgb = new int[N][3];
		st = new StringTokenizer(br.readLine());
		rgb[0][0] = Integer.parseInt(st.nextToken());
		rgb[0][1] = Integer.parseInt(st.nextToken());
		rgb[0][2] = Integer.parseInt(st.nextToken());
		int[][] tem = {{1,2},{0,2},{0,1}}; 
				
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = (rgb[i-1][tem[j][0]] > rgb[i-1][tem[j][1]] ? rgb[i-1][tem[j][1]] : rgb[i-1][tem[j][0]] ) + Integer.parseInt(st.nextToken());
			}
		}
	int r = rgb[N-1][0];
	int g = rgb[N-1][1];
	int b = rgb[N-1][2];
	int	min = Math.min(Math.min(r, g),b);
	System.out.println(min);
	}
}
