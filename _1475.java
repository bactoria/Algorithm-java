import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1475 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final String N = br.readLine();
		int[] count = new int[10];
		
		for (int i = 0; i < N.length(); i++) {
			count[N.charAt(i)-'0'] ++;
		}
		count[6] = (int)Math.ceil((count[6]+count[9])/2.0);
		count[9] = 0;
		
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < count.length; i++) {
			if(count[i] > max ) max = count[i];
		}
		System.out.println(max);
	}

}
