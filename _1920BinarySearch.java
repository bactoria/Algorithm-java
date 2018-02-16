import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 1.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/1920
 *  
 */
public class _1920BinarySearch {

	private static int[] array;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		array = new int[N];
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(array);
		
		final int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(temp,0,N-1) + "\n");
		}
		
		System.out.println(sb.toString());
	}

	private static int binarySearch(int value, int left , int right) {
		// TODO Auto-generated method stub
		int cur = (left+right) /2;
		if(array[cur] == value) {
			return 1;
		}
		if(left >= right) {
			return 0;
		}
		if(array[cur] > value) {
			return binarySearch(value,left,cur-1);
		}else {
			return binarySearch(value,cur+1,right);
		}
		
	}
}
