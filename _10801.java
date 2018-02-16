//180125
//난이도 최하
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10801 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int count = 0;
		int[][] c = new int[2][10];
		for (int i = 0; i < 2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				c[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < 10; i++) {
			if(c[0][i] > c[1][i]) count++;
			else if(c[0][i] < c[1][i]) count--;
		}
		
		if(count > 0) System.out.println("A");
		else if(count < 0) System.out.println("B");
		else System.out.println("D");
	}

}
