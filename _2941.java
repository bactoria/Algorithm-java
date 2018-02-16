import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2941 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		String s = br.readLine();
		int count = s.length();
		String[] check = {"c=","c-","dz=","d-","lj","nj","s=","z="};
		for (int i = 0; i < s.length()-1; i++) {
			sb = new StringBuilder();
			String temp = String.valueOf(sb.append(s.charAt(i)+""+s.charAt(i+1)));
			for (int j = 0; j < check.length; j++) {
				if(check[j].equals(temp)) {
					count--;
					if(j==7&& i>0) {
						if(s.charAt(i-1) == 'd') count--;
					}
				}
			}
		}
	
		System.out.println(count);
	}
	
	

}
