import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : PC
 * @date   : 2018. 1. 25.
 *   문제        : 최댓값
 *  남길 말      : 단순노가다

 */
public class _2566 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int x=-1, y=-1, max = Integer.MIN_VALUE;

		for (int i = 1; i <= 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 9; j++) {
			int temp = Integer.parseInt(st.nextToken());
				if(max < temp) {
					max = temp;
					x = i;
					y = j;
				}
			}
		}
		sb.append(max+"\n");
		sb.append(x+" "+y);
		System.out.println(sb.toString());
	}
}
