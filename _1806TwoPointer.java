import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 7.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/1806
 *  투포인터
 */
public class _1806TwoPointer {

	public static int solve(final int N, final int S, final int[] array) {
		int minLen = 1987654321;
		int leftP = 0, rightP = 0, sum = 0;
		
		while(rightP < N) {
			sum += array[rightP];
			
			// sum이 S보다 클 때까지 위의 연산을 반복한다.
			if(sum < S) {
				rightP++;
				continue;
			}
			
			//sum >= S . 최소길이 구하기
			while(leftP < rightP) {
				sum -= array[leftP];
				if(sum >= S) leftP++;
				else {
					sum += array[leftP];
					break;
				}
			}
			minLen = Math.min(minLen,rightP-leftP+1);
			rightP++;
		}
		if(minLen == 1987654321) return 0;
		else return minLen;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int S = Integer.parseInt(st.nextToken());
		final int[] array = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) 	array[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(N,S,array));
	}
}
