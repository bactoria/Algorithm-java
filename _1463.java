import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1463 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] array = new int[N + 1];
		/*if(N<4) {
			System.out.println(N/2);
			return;
		}
		*/
		array[1] = 0;
//		array[2] = 1;
	//	array[3] = 1;

		for (int i = 2; i <= N; i++) {
			if (i % 6 == 0) {
					array[i] = Math.min(Math.min(array[i / 2], array[i / 3] ),array[i-1]) + 1;
			}else if (i % 3 == 0) array[i] = Math.min( array[i / 3],array[i - 1] ) + 1;
			 else if (i % 2 == 0) array[i] = Math.min(array[i / 2],array[i-1]) + 1;
			 else array[i] = array[i - 1] + 1;
			}
		
		System.out.println(array[N]);
	}
}
