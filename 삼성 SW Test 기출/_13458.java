import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13458 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		final int N = Integer.parseInt(br.readLine());
		
		int[] classes = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
			classes[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		final int B = Integer.parseInt(st.nextToken());
		final int C = Integer.parseInt(st.nextToken());		

		for (int i = 0; i < N; i++) {
			classes[i] -= B;
		}
		long count = N;
		for (int i = 0; i < N; i++) {
			if(classes[i] <= 0 ) continue;
			
			count += (classes[i] / C);
			if((classes[i] % C ) != 0) count++;
		}
		
		System.out.println(count);
	}
}
