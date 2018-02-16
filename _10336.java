시간초과

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : PC
 * @date   : 2018. 1. 26.
 *   문제        : 
 *  남길 말      : ()() 괄호문제는 여는건 자유로운데(조건없음) 닫는거는 열려있어야 닫을  수 있다.(조건)  그리고 열고닫고 sum이 0이어야 한다.

 */
public class _10336 {

	private static int[] array;

	public static boolean hasMinus() {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (sum < 0)
				return true;
		}

		if (sum != 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		st.nextToken(); // N값 필요없음. 그냥무시함
		final int Q = Integer.parseInt(st.nextToken());

		String s = br.readLine();
		int sLen = s.length();
		array = new int[sLen + 1];
		int[] q = new int[Q];
		for (int i = 1; i <= sLen; i++) {
			if (s.charAt(i - 1) == '(')
				array[i] = 1;
			else
				array[i] = -1;
		}

		for (int i = 0; i < Q; i++) {
			q[i] = Integer.parseInt(br.readLine());
		}
		// ------------------ 초기화 끝--------------------------

		for (int i = 0; i < Q; i++) {
			int temp = array[q[i]]; // 원래 방향 ( 원래 -1 ")"이었으면 ( 가됬으니 앞에서 닫을수 있으면 닫아줘야함.. 조건은 count > 1 여야함. count는 현재
									// 열려있는 ( 의 갯수
			array[q[i]] *= -1; // 괄호 방향 바꾸기

			if (temp == -1) { // 원래 ) 였다면
				for (int j = 1; j <= sLen; j++) {
					if (array[j] == 1) {
						array[j] = -1;
						if (!hasMinus()) { // 완전한 ()()()괄호라면
							System.out.println(j);
							break;
						} else array[j] = 1;
					}
				}
			} else { // 원래 ( 였다면
				for (int j = 1; j <= sLen; j++) {
					if (array[j] == -1) {
						array[j] =  1;
						System.out.println(j);
						break;
					}
				}
			}
		}
	}

}
