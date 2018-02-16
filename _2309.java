import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2309 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int N = 9;
		int[] height = new int[N];
		int everyHeight = 0;
		for (int i = 0; i < N; i++) {
			height[i] = Integer.parseInt(br.readLine());
			everyHeight += height[i];
		}
		Arrays.sort(height);
		//가짜난쟁이 찾기
		int fakeI = -1,fakeJ = -1;
		for (int i = 0; i < N-1; i++) {
			for (int j = i+1; j < N; j++) {
				
				int sevenHeight = everyHeight - height[i] - height[j];
				if(sevenHeight == 100) {
					fakeI = i;
					fakeJ = j;
				}else if(sevenHeight < 100) break; //더 가봐야 sevenHeight는 작아질뿐이므로 의미없다
			
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			if(i == fakeI || i == fakeJ ) continue; 
			sb.append(height[i]).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
