import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14890 {

	private static int result;
	private static int[][] map;
	private static int N;
	private static int L;

	public static void checkRow(int i) {
		
		int count = 1;
		int cur=0,next=0;
		
		for (int j = 0; j < N; j++) {
			cur = map[i][j];
			if(j+1 < N) next = map[i][j+1];
			
			if(j == N-1) {
				break;
			}
			
			//평평한길
			if(cur == next) count++;
			
			//오르막길(1칸)
			else if(next == cur+1) {
				if(count < L) return;
				else count = 1;
			}
			//내리막길(1칸)
			else if(next == cur-1){
				if(count < 0) return;
				else count = -L+1;
			}else return;
		}
		if(count>= 0 ) {
			result++;
		}
	}

	public static void checkCol(int j) {
		int count = 1;
		int cur=0,next=0;
		
		for (int i = 0; i < N; i++) {
			cur = map[i][j];
			if(i+1 < N) next = map[i+1][j];
			
			if(i == N-1) {
				break;
			}
			//평평한길
			if(cur == next) count++;
			
			//오르막길(1칸)
			else if(next == cur+1) {
				if(count < L) return;
				else count = 1;
			}
			//내리막길(1칸)
			else if(next == cur-1){
				if(count <0) return;
				else count = -L+1;
			}else return;
		}
		if(count >=0) {
			result++;
		}
	}


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		result = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) checkRow(i);
		for (int j = 0; j < N; j++)	checkCol(j);
		System.out.println(result);
	}

}
