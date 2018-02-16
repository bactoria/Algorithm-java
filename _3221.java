...
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3221 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		final int L = Integer.parseInt(st.nextToken());
		final int T = Integer.parseInt(st.nextToken());
		final int N = Integer.parseInt(br.readLine());
		int[] array = new int[N + 1];

		// init()
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int tempI = Integer.parseInt(st.nextToken());
			String tempS = st.nextToken();
			if (tempS == "L") {
				array[tempI] = -1;
			} else if (tempS == "D") {
				array[tempI] = 1;
			}
		}

		boolean CurFull = false;
		for (int t = 1; t <= T; t++) {
			for (int l = 0; l <= L; l++) {
				switch (array[l]) {
				case 0 :
					continue;
				
				case -1 : //왼쪽방향이면
					if(array[l-1] == 0) { // 왼쪽 비었으면
						array[l-1] = -1;
						array[l] = 0;
					}else { //왼쪽이 차있으면
						array[l-1] = 3;
						array[l] = 0;
					}
					
				case 1 : //오른쪽방향이면
					if(array[l+1] == 0) { //오른쪽 비었으면
						array[l+1] = 1;
						array[l] = 0;
					}else { //오른쪽 차있으면
						array[l] = -1;
						array[l] = 9;
					}
				case 3 :  //한점에 개미 두마리있다.
					if(array[l-1] == 0) { // 왼쪽 비었으면
						array[l-1] = -1;
						array[l] = 0;
					}else { //왼쪽이 차있으면
						array[l-1] = 3;
						array[l] = 0;
					}
					if(array[l+1] == 0) { //오른쪽 비었으면
						array[l+1] = 1;
						array[l] = 0;
					}else { //오른쪽 차있으면
						array[l] = -1;
						array[l] = 9;
					}
					
					
				}

			}
		}

	}
}
