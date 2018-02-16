import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1004 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			int count = 0;
			
			
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			
			int N = Integer.parseInt(br.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int tempx = Integer.parseInt(st.nextToken());
				int tempy = Integer.parseInt(st.nextToken());
				int round = Integer.parseInt(st.nextToken());
			
				int tempxx1 = tempx-x1;
				int tempyy1 = tempy-y1;
				int tempxx2 = tempx-x2;
				int tempyy2 = tempy-y2;
				int temprr = round*round;
				int tempC = 0;
				if((tempxx1*tempxx1 + tempyy1*tempyy1) > temprr) tempC++;
				if((tempxx2*tempxx2 + tempyy2*tempyy2) > temprr) tempC++;
			
				if(tempC==1) count++;
			}
			sb.append(count+"\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}

}
