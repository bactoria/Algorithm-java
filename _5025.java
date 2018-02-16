몰라
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5025 {
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int temp = a % b;
			a= b;
			b = temp;
		}
		return a;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		final int TT = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= TT; tt++) {
			st= new StringTokenizer(br.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		if(H>W) {
			int temp = H;
			H = W;
			W = temp;
		}
		
		
		int gcd = gcd(W-1,H-1); //W-1 H-1 의 최대공약수
		int lcd = ((W-1) / gcd ) * (H-1) ;  //최소공배수
		int count = lcd + 1; //중복포함 X갯수
		// 중복된 X갯수 구하기
		int buck =  (H-1) / gcd ;
		int c = 0;
		int na = 0;
		for (int i = 1; i < buck; i++) {
			c += i * ((W-1)/(H-1));
			na += W % (H*buck);
			if(na>H) {
				na -= H;
				c += (i-1);
			}
		}
		
		sb.append((count - c)+"\n");
		}
		System.out.println(sb.toString());
	}
}
