package DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 30.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/13132
 *  
 */
public class _13132 {

	
	private static double[][] info;
	private static double M;
	private static double result;
	private static int B;
	private static int N;

	public static void DFS(double curM,int n,double per) {
		if(curM <= B) {
			return;
		}
		if(n==N) {
			if(curM > 100) result+=per;
			return;
		}
		double winMoney = curM+curM*M*(info[n][1]-1);
		double winPer = info[n][0] * per;
		double loseMoney = curM-curM*M;
		double losePer = per - winPer;
		//다음게임 참가할게요
		DFS(winMoney,n+1,winPer);

		DFS(loseMoney,n+1,losePer); //꼬랐어
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //경기수
		M = Double.parseDouble(st.nextToken())/100.0; //배팅비율
		B = Integer.parseInt(st.nextToken()); //마지노선
		info = new double[N][2]; //[0] : 딸 확률    [1] : 배당
		result = 0.0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			info[i][0] = Double.parseDouble(st.nextToken())/100.0;
			info[i][1] = Double.parseDouble(st.nextToken());
		}
		
		DFS(100,0,100); //100만원 들고 들어가즈아!
		System.out.println(result);
	}

}
