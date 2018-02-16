import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4796 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	StringTokenizer st;
		int tt = 0;
		while(true) {
			tt++;
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
		
			if(l + p + v == 0) break;

			
			
			sb.append("Case "+tt+": "+((v / p) * l + Math.min((v%p),l))+"\n");
		
		}
		System.out.println(sb.toString());
	}

}
