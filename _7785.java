import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class _7785 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		//내림차순인 TreeSet 생성
		Set<String> personSet = new TreeSet<>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		
		final int N = Integer.parseInt(br.readLine());

		for (int n = 1; n <= N; n++) {
				st = new StringTokenizer(br.readLine(), " ");
			
				String name = st.nextToken();
				String enterOrLeave = st.nextToken();
				
				if(enterOrLeave.equals("enter")) {
					personSet.add(name);
				}else if(enterOrLeave.equals("leave")) {
					personSet.remove(name);
				}else return; //Error
		}
		
		for(String s : personSet)	sb.append(s+"\n");
		
		System.out.println(sb.toString());
	}
}