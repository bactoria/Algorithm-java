import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 28.
 *  https://github.com/bactoria/BOJ/
 * 

 */
public class _10656 {

	private static int N;
	private static int M;
	private static char[][] mapRow;
	private static char[][] mapCol;
	private static StringBuilder sb;
	private static int count;
	
	//���ΰ˻�
	public static boolean searchRow(int i, int j) {
		if (j > M - 2)
			return false;
		if (mapRow[i][j - 1] == '.')
			return false; // ������ ����
		if (mapRow[i][j] == '#' || mapRow[i][j + 1] == '#' || mapRow[i][j + 2] == '#')	return false; // �ڷ� 1ĭ or 2ĭ�� ����������(# : ��������. R : �̹� ���ο��� ����)
		
		//���õ� ĭ ���
		sb.append(i + " " + j + "\n");
		count++;
		
		while (true) {
			mapRow[i][j] = '#';
			j++;
			if (j > M) return true;
			if (mapRow[i][j] == '#') return true;
		}
	}
	
	//���ΰ˻�
	public static void searchCol(int i, int j) {
		if (i > N - 2)
			return;
		if (mapCol[i - 1][j] == '.') return; // ������ ����
		if (mapCol[i][j] == '#' ||mapCol[i + 1][j] == '#' || mapCol[i + 2][j] == '#') return; // �ڷ� 1ĭ or 2ĭ�� ����������(# : ��������. C : �̹� ���ο��� ����)
		
		//���õ� ĭ ���
			sb.append(i + " " + j + "\n");
			count++;
			
		while (true) {
			mapCol[i][j] = '#';
			i++;
			if (i > N) return;
			if (mapCol[i][j] == '#') return;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		mapRow = new char[N + 1][M + 1];
		mapCol = new char[N + 1][M + 1];
		count = 0;
		
		for (int i = 1; i <= N; i++) {
			char[] c = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				mapRow[i][j] = c[j - 1];
				mapCol[i][j] = c[j - 1];
			}
		}
		
		for (int i = 0; i <= N; i++) mapRow[i][0] = '#';
		for (int i = 0; i <= M; i++) mapRow[0][i] = '#';
		for (int i = 0; i <= N; i++) mapCol[i][0] = '#';
		for (int i = 0; i <= M; i++) mapCol[0][i] = '#';

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				//Row�˻����� ���É�ٸ� Col�˻��� �ʿ� ����.
				if(!searchRow(i, j)) searchCol(i, j);
			}
		}
		System.out.println(count);
		System.out.println(sb.toString());
	}

}
