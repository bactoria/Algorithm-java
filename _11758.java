�ͳ�
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : PC
 * @date   : 2018. 1. 26.
 *   ����        : �ð� �ݽð� ���ϱ�
 *  ���� ��      : ���� �Ⱦ��� Ǯ������..
 *  		������ ����Ȩ������ ���� ������ ��ũ����.
 *  

 */
public class _11758 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		int[] x = new int[3];
		int[] y = new int[3];
		int reverse = 1;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}

		int xx = x[1] - x[0];
		int yy = y[1] - y[0];

		int xxx = x[2] - x[1];
		int yyy = y[2] - y[1];

		if (xx * yyy == yy * xxx) {
			System.out.println(0);
			return;
		}

		if (xx < 0)
			reverse = -1;

		if (yy != 0 || yyy != 0 || xx != 0 || xxx != 0) {
			int sub = (((yyy * yy) > (xxx * xx)) ? 1 : -1); // yyy�� ��ǥ.. �����U�� ������ ����
			System.out.println(sub * reverse);
		}else {
			
			
			
		}
		
		
	}
}
