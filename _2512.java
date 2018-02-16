오지게 틀려버림
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class _2512 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		final int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] city = new int[N+1];
		
		//도시에 필요한 총 예산
		int sum = 0;
		
		for (int i = 1; i <= N; i++)	{
			sum += city[i] = Integer.parseInt(st.nextToken());
		}
		
		int budget = Integer.parseInt(br.readLine());
		Arrays.sort(city);
		
		int count = budget - city[1]*N;
		int cur = 2;
		int price = city[1];
		
		//예산이 도시에 다 놔눠줄수 있다면
		if(sum <= budget) {
			System.out.println(city[N]);
			return;
		}
		
		//예산이 최소값보다 작을경우
		if(count <= 0) {
			System.out.println(budget/N);
			return;
		}
		
		while(true) {
			//현재도시의 예산과 같다면 다음도시로 (도시는 소팅되어있는 상태)
			if(city[cur] == price) cur++;
			
			//가격 올려도 예산이 남는다면
			if(count >= N-cur+1) {
				count -= (N-cur+1);
				price++;
			
			//가격올리면 예산이 부족해지면
			}else { 
				System.out.println(price);
				return;
			}
		}
	}
}
