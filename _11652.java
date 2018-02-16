import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class _11652 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		final int N = Integer.parseInt(br.readLine());
		Map<Long,Integer> map = new HashMap<Long,Integer>();
		int maxV = 1;
		long maxP = 0;
		for (int i = 0; i < N; i++) {
			long temp = Long.parseLong(br.readLine());
			
			if(map.containsKey(temp)) {
				int tempV = map.remove(temp)+1;
				map.put(temp, tempV);
				
				if(maxV == tempV) {
					maxP = maxP > temp ? temp : maxP;
				}else if(maxV < tempV) 	{
					maxV = tempV;
					maxP = temp;
				}
			
			}else {
				map.put(temp,1);
				if(map.size()==1) {
					maxP = temp;
				}
				if(maxV == 1) {
					maxP = maxP < temp ? maxP : temp;
				}
			}
		}
		System.out.println(maxP);
	}

}
