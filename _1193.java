import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1193 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		int count =0 ;
		int sum= 0;
		while(sum<N) {
			
			count++;
			sum += count;
		}
		
		int a = count+N-sum;
		int b = sum-N+1;
		if(count%2 == 0) {			
			sb.append((a)+"/"+(b));
		}else{			
			sb.append((b)+"/"+(a));
		}
		System.out.println(sb.toString());
	}

}
