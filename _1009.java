import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : PC
 * @date   : 2018. 1. 25.
 *   문제        : 분산처리
 *  남길 말      : 

 */
public class _1009 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
	
		final int TT = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int tt = 0; tt < TT; tt++) {
			st = new StringTokenizer(br.readLine());
			
			boolean[] visited = new boolean[10];
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a>9) a %= 10;
			if(a==0) {
				sb.append("10\n");
				continue;
			}
			int cycle = 0;
			int calA = a;

			while(!visited[calA]) {
				visited[calA] = true;
				cycle++;
				calA = ( calA * a ) % 10;
			}
			
			b %= cycle;
			if(b==0) b = cycle;
			while(--b>0) calA = calA*a % 10;
			sb.append(calA+"\n");
		}
		System.out.println(sb.toString());
	}
}
