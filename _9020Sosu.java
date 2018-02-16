import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _9020Sosu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TT= Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		boolean[] isSosu = new boolean[10001];
		Arrays.fill(isSosu, true);
		isSosu[0] = false;
		isSosu[1] = false;
		
		//소수구하기
		for (int i = 2; i <= 100; i++) {
			for (int j = 2; i*j < isSosu.length; j++) {
				isSosu[i*j] = false;
			}
		}
		for (int tt = 1; tt <= TT; tt++) {
			
			int n = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < n; i++) {
				int a = n/2 + i;
				int b = n/2 - i;
				if(isSosu[a] && isSosu[b]) {
					sb.append((b)+" "+(a)+"\n");
					break;
				}
			}
		}
		System.out.println(sb.toString());
	}
}
