import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 1.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/1564
 *  �̰� 5�ڸ��ϱ� mod�� 100000 ���� �ߴµ� ���������.
 *  10000000�ص� Ʋ�� ���̳��Դ�. �ֱ׷�����
 *  �ڿ� 0�� �ʿ�����ϱ� �� �������� ó���ѰŸ� ��������ʳ�..
 */
public class _1564 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		long start = 1;
		long result = 1;
		long mod = 1000000000000L;
		
		while(start <= n) {
			result *= start;
			while(true) {
				if(result%10 == 0) result /= 10;
				else break;
			}
			start++;
			result %= mod;
		}
		
		int count = 0;
		int temp = (int)(result%100000);
		while(true) {
			count++;
			temp /=10;
			if(temp == 0) break;
		}

		for (int i = count; i < 5; i++) {
			sb.append(0);
		}
		sb.append(result%100000);
		System.out.println(sb.toString());
	}
}
