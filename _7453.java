import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _7453 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		final int N = Integer.parseInt(br.readLine());
		Map<Integer,Integer> cdMap = new HashMap<Integer,Integer>();
		
		int[] A = new int[N];
		int[] B = new int[N];
		int[] C = new int[N];
		int[] D = new int[N];
		
		int[] AB = new int[N*N];
		Arrays.fill(AB,Integer.MIN_VALUE);
		long result = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			A[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
			C[i] = Integer.parseInt(st.nextToken());
			D[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				AB[i*N+j] = A[i] + B[j];
				int temp = C[i] + D[j];
				if(cdMap.containsKey(temp)) cdMap.replace(temp,cdMap.get(temp)+1);
				else cdMap.put(temp, 1);
			}
		}
		
		for (int i = 0; i < N*N; i++) {
			if(AB[i] == Integer.MIN_VALUE) break;
			
			int searchKey = -AB[i];
			if(cdMap.containsKey(searchKey)) {
				result += cdMap.get(searchKey);
			}
		}
		System.out.println(result);
	}
}