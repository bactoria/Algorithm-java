import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class _11279 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final int N = Integer.parseInt(br.readLine());
		Map<Integer,Integer> map = new HashMap<>();
		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			if (temp == 0) {
				if (set.size() == 0)
					sb.append(0 + "\n");
				else {
					int last = set.last();
					if(map.get(last) == 1) {
						set.pollLast();
						map.remove(last);
					}
					else  map.replace(last, map.get(last)-1);
					sb.append(last+"\n");
				}
				} else {
				set.add(temp);
				if(map.containsKey(temp)) map.replace(temp, map.get(temp)+1);
				else map.put(temp, 1);
				}
		}
		System.out.println(sb.toString());
	}
}
