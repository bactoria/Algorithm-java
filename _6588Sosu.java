import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : PC
 * @date   : 2018. 1. 26.
 *   문제        : 100만이하 소수합인 짝수구하기
 *  남길 말      : 어려웠따..

 */
public class _6588Sosu {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean[] notSosu = new boolean[1000001];
		int[] sosu = new int[1000001];
		int N = -1;
		int count = 0;
		for (int i = 2; i <= 1000000; i++) {
			if (notSosu[i] == true) continue;
			sosu[count++] = i;
			for (int j = 2; i * j < notSosu.length; j++) {
				notSosu[i * j] = true;
			}
		}
		while( (N = Integer.parseInt(br.readLine())) != 0 ){
		for (int i = 1; i < sosu.length; i++) {
			boolean temp = notSosu[N-sosu[i]];
			if(!temp) {
				sb.append(N+" = "+sosu[i]+" + "+(N-sosu[i])+"\n");
				break;
			}
		}
		}
		System.out.println(sb.toString());
	}
}
