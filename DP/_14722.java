package DP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
��������
2
0 2
0 0
�ݷʸ�ã�Ƽ� �����ۿ÷Ⱦ���.
/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 1.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/14722
 *  ��������
 */
public class _14722 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N+1][N+1];
		int[][][] dp = new int[N+1][N+1][3];
		StringTokenizer st;
		try {}
		catch(Array)
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				int[] up = dp[i-1][j];
				int[] left = dp[i][j-1];
				dp[i][j] = new int[]{Math.max(up[0], left[0]),Math.max(up[1], left[1]),Math.max(up[2], left[2])};
				//���� �������ִ� ����
				int curMilk = map[i][j];
				//��������� �Ա����� ������ ��������?
				int prevMilk = (map[i][j]-1); if(prevMilk== -1) prevMilk = 2;
				//ù������ ��������� �Ǿ�� �Ѵ�.
				if(dp[i][j][prevMilk] == 0 && (curMilk !=0)) continue;
				//������������ ������ ������ ��������+1
				dp[i][j][curMilk] = Math.max(dp[i][j][curMilk],dp[i][j][prevMilk]+1);
			}
		}
		System.out.println(Math.max(Math.max(dp[N][N][0],dp[N][N][1]),dp[N][N][2]));
	}
}