������ Ʋ������
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
		
		//���ÿ� �ʿ��� �� ����
		int sum = 0;
		
		for (int i = 1; i <= N; i++)	{
			sum += city[i] = Integer.parseInt(st.nextToken());
		}
		
		int budget = Integer.parseInt(br.readLine());
		Arrays.sort(city);
		
		int count = budget - city[1]*N;
		int cur = 2;
		int price = city[1];
		
		//������ ���ÿ� �� �����ټ� �ִٸ�
		if(sum <= budget) {
			System.out.println(city[N]);
			return;
		}
		
		//������ �ּҰ����� �������
		if(count <= 0) {
			System.out.println(budget/N);
			return;
		}
		
		while(true) {
			//���絵���� ����� ���ٸ� �������÷� (���ô� ���õǾ��ִ� ����)
			if(city[cur] == price) cur++;
			
			//���� �÷��� ������ ���´ٸ�
			if(count >= N-cur+1) {
				count -= (N-cur+1);
				price++;
			
			//���ݿø��� ������ ����������
			}else { 
				System.out.println(price);
				return;
			}
		}
	}
}
