//180125
//난이도 최하
//공격력 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12790 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		final int TT = Integer.parseInt(br.readLine());
		
		for (int tt = 1; tt <= TT; tt++) {
			st = new StringTokenizer(br.readLine());
			
			int HP = Integer.parseInt(st.nextToken());
			int MP = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			
			HP += Integer.parseInt(st.nextToken());
			MP += Integer.parseInt(st.nextToken());
			S += Integer.parseInt(st.nextToken());
			H += Integer.parseInt(st.nextToken());
			
			if(HP<1) HP=1;
			if(MP<1) MP=1;
			if(S <0)  S=0;
			sb.append( HP + (5 * MP) + (2 * S) + (2 * H) +"\n");
		}
		System.out.println(sb.toString());
	}
	
}
