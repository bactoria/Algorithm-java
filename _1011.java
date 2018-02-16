import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1011 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int TT = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= TT; tt++) {
			st = new StringTokenizer(br.readLine());
			int tempA = Integer.parseInt(st.nextToken());
			int tempB = Integer.parseInt(st.nextToken());
			int dist = tempB-tempA;

			int temp = (int)Math.sqrt(dist);
			int tempZ = temp*temp;
			if(dist == tempZ) {
				sb.append((temp<<1)-1+"\n");
				continue;
			}
			int namu = dist - tempZ;
			if(namu <= temp)	sb.append((temp<<1)+"\n");
			else sb.append((temp<<1)+1+"\n");
		}
		
		System.out.println(sb.toString());
	}
}