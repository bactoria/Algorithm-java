import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11866 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		sb.append("<");
		boolean[] outed = new boolean[N+1];
		
		int count = 0;
		for (int i = 0; i < N; i++) {
			int tempM = M;
			
			while(true) {
				count++;
				if(count>N) count = 1;
				if(!outed[count]) {
					tempM--;
				}	
					if(tempM==0) {
						outed[count] = true;
						sb.append(count+", ");
						break;
				}
			}
		}
		
		int temp = sb.length();
		sb.delete(sb.length()-2,sb.length());
		sb.append(">");
		System.out.println(sb.toString());
	}

}
