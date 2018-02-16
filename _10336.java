�ð��ʰ�

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : PC
 * @date   : 2018. 1. 26.
 *   ����        : 
 *  ���� ��      : ()() ��ȣ������ ���°� �����ο(���Ǿ���) �ݴ°Ŵ� �����־�� ����  �� �ִ�.(����)  �׸��� ����ݰ� sum�� 0�̾�� �Ѵ�.

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
		st.nextToken(); // N�� �ʿ����. �׳ɹ�����
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
		// ------------------ �ʱ�ȭ ��--------------------------

		for (int i = 0; i < Q; i++) {
			int temp = array[q[i]]; // ���� ���� ( ���� -1 ")"�̾����� ( �������� �տ��� ������ ������ �ݾ������.. ������ count > 1 ������. count�� ����
									// �����ִ� ( �� ����
			array[q[i]] *= -1; // ��ȣ ���� �ٲٱ�

			if (temp == -1) { // ���� ) ���ٸ�
				for (int j = 1; j <= sLen; j++) {
					if (array[j] == 1) {
						array[j] = -1;
						if (!hasMinus()) { // ������ ()()()��ȣ���
							System.out.println(j);
							break;
						} else array[j] = 1;
					}
				}
			} else { // ���� ( ���ٸ�
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
