import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14490Daeyul {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] s = br.readLine().split(":");
		
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		int calN = n;
		int calM = m;
		if(calM>calN) {
			int temp = calM;
			calM = calN;
			calN = temp;
		}
		// n > m
		while(calM != 0) {
			int temp = calN % calM;
			calN = calM;	
			calM = temp;
		}
		
		n /= calN;
		m /= calN;

		System.out.println(String.format("%d:%d", n,m));
	}
}
