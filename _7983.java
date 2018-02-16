import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 11.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/7983
 *  
 */
public class _7983 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[][] array = new int[N][2]; // [0] : �����ϼ�     [1] : ������
		int honeyDay = 0; //���
		
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			array[i][0] = Integer.parseInt(st.nextToken());
			array[i][1] = Integer.parseInt(st.nextToken());
		}
		
		//������ �������� ����
		Arrays.sort(array,(o1,o2) -> o2[1] - o1[1]);

		//�ڿ������� ������
		int startDay = array[0][1];
		for (int i = 0; i < N-1; i++) {
					if(startDay - array[i][0] > array[i+1][1] ) { // ����ִ�.
						startDay = array[i+1][1];
					}else { //�������.
						startDay -= array[i][0];
					}
		}

		honeyDay = Math.max(honeyDay, startDay - array[N-1][0]);
		
		System.out.println(honeyDay);
	}
}