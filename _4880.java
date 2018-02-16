import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _4880 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = null;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			int a3 = Integer.parseInt(st.nextToken());
		
			if(a1 == 0 && a2 == 0 && a3 == 0) {
				System.out.println(sb.toString());
				return;
			}
			
			if(a1+a3 == a2*2) sb.append("AP "+(a3+a2-a1)+"\n");
			else sb.append("GP "+(a3 * a2 / a1)+"\n");
		}
	}

}
