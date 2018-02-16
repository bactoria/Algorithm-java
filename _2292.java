import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2292 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int count = 1;
		int curMax = 1;
		while(N>curMax) {
			curMax += count*6;
			count++;
		}
		System.out.println(count);
	}

}
