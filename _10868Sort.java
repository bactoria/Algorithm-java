import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang
 * @date   : 2018. 1. 26.
 *  https://github.com/bactoria/BOJ/
 *  n�� 10������. 10������ ���� ���ؾ��Ѵ�.
 *  �ð����⵵ nlogn �̸� 1���̴�. 
	
 */
public class _10868Sort {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		st 
		= new StringTokenizer(br.readLine());
		final int N = Integer.parseInt(st.nextToken());
		final int M = Integer.parseInt(st.nextToken());
		
		int[][] array = new int[N+1][2];   //[0] : ������    [1] : value;
		
		for (int i = 1; i <= N; i++) {
			array[i][0] = i; //������
			array[i][1] = Integer.parseInt(br.readLine()); //value
		}
		
		Arrays.sort(array,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[1]-o2[1];
			}
		});
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			//start <= ������ <= end
			for (int j = 1; j <= N; j++) {
				if(array[j][0] >=start) if(array[j][0] <= end) {
					sb.append(array[j][1]+"\n");
					break;
				}
			}
		}
		System.out.print(sb.toString());
	}
}