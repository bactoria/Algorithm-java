import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8958OX_Quize {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int sum = 0;
			String as = br.readLine();
			int[] score = new int[as.length()+1];
			for (int i = 0; i < as.length(); i++) {
				if(as.charAt(i) == 'O') {
					score[i+1] = score[i]+1;
					sum += score[i+1];;
				}
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb.toString());
	}
}
