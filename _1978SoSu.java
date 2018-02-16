import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1978SoSu {
	private final static int MAX_POINT = 1001;
	private static boolean[] notSosu = new boolean[MAX_POINT];
	
	
	public static void sosu() {
		notSosu[1] = true;
		
		for (int i = 2; i < MAX_POINT; i++) {
			int tempI = i;
			int temp = 2;
			if(notSosu[i]) continue;
			
			while((tempI = i* temp) < MAX_POINT) {
				notSosu[tempI] = true;
				temp++;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		sosu();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		String[] s = br.readLine().split(" ");
		int count = 0;

		for (int i = 0; i < s.length; i++) {
			if( !notSosu[Integer.parseInt(s[i])] ) count++; //소수라면 1증가
		}
		System.out.println(count);
	}
}