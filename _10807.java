import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  
 */
public class _10807 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[][] count = new int[101][2];
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(st.nextToken());	
			if(temp>0) count[temp][1]++;
			else 	   count[-temp][0]++;
		}
		
		final int point = Integer.parseInt(br.readLine());
		if(point>0) System.out.println(count[point][1]);
		else        System.out.println(count[-point][0]);
	}
}
