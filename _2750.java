import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author : PC
 * @date   : 2018. 1. 25.
 * 문제 이름     : N개의 수 정렬하기
 *  난이도       : 최하
 */
public class _2750 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		int array[] = new int[N];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(array);
		for (int i = 0; i < array.length; i++) {
			sb.append(array[i]+"\n");
		}
		System.out.println(sb.toString());
	}
}
