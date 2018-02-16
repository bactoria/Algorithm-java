import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2875 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		final int K = Integer.parseInt(st.nextToken());
		
		int teamC; 
		int temp = 0;
		 
		if(N/2 > M) { //���ڰ� ���´�!
			teamC = M;
			temp = (N - 2 * teamC); //���ڳ�����
		}else {
			teamC = N/2;
			temp = N % 2 + (M - teamC) ; //���ڳ����� + ���ڳ�����
		}
		int cal = (int) Math.ceil( (K-temp) / 3.0 ) ;
		if (cal<0) cal = 0;
		System.out.println(teamC - cal);
	}

}
