import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14919 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int tempC = s.length;
		int[] count = new int[N];
		int[] go = new int[tempC];

		for (int i = 0; i < tempC; i++) {
			go[i] = (int)((Double.parseDouble(s[i])*N)); //0.5 1.0 1.5 ...
			count[go[i]]++;
		}
		
		for (int i = 0; i < N; i++)	sb.append(count[i]+" ");
		
		System.out.println(sb.toString());
		double a = 0.5;
		System.out.println(Math.ceil(a,));
	}
}
