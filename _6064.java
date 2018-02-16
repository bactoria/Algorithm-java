import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6064 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			st = new StringTokenizer(br.readLine());

			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int result = -1;
			
			if (m > n) {
				int temp = m;
				m = n;
				n = temp;
				temp = x;
				x = y;
				y = temp;
			}
			// m < n ÀÌ´Ù.

			int N_M = n - m;

			if (x == y) {
				result = x ;
			} else if (x > y) {
				if((x-y) % N_M  == 0) result = ( ( x - y ) / N_M )*n + y;
			} else {
				int temp = 0;
				int count = 0;
				while(true) {
					temp+= N_M;
					temp %= m;
					if(temp == y-x) {
						result = ( temp / N_M )*count + x;  
						break;
					}
					count++;
				}
			}

			sb.append(result+"\n");

		}
		System.out.println(sb.toString());
	}

}
