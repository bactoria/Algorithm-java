import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2857 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = new String[5];
		for (int tt = 0; tt < 5; tt++) {
			s[tt] = br.readLine();
		}
		
		for (int tt = 0; tt < 5; tt++) {
			for (int i = 0; i < s[tt].length()-2; i++) {
				if(s[tt].charAt(i)=='F') {
					if(s[tt].charAt(i+1)=='B' && s[tt].charAt(i+2)=='I') { 
						sb.append((tt+1)+" ");
						break;
					}
				}
			}
		}
		if(sb.length()==0) System.out.println("HE GOT AWAY!");
		else               System.out.println(sb.toString());
	}

}
