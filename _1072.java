import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 2. 2.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/problem/1072
 *  와 이거 지금 이대로 제출하면 틀렸다고뜸
 *  이유는 curPer per 이쪽에 되있는게 int형이라서 그런데
 *  이거 long으로 바꾸면 됨. 물론 이거 앞에 100을 먼저 해줘서그런데
 *  이거혹시 뒤에 100곱하는거랑 값이 다른가?
 *  
 */
public class _1072 {

	private static int X;
	private static int Y;
	private static int per;
	private static int result; 
	
	public static void binarySearch(int left, int right) {
		int cur = (left+right) /2;
		int curPer = 	(int)(((Y+cur) / (double)(X+cur) )*100);	
		int cur_1Per = (int)(((Y+cur-1) / (double)(X+cur-1) )*100);
		if(curPer == cur_1Per+1 && curPer == per+1){
			result = cur;
			return;
		}
		if(left>=right) {
			System.out.println("Emergency");
			return;
		}
		if(curPer > per) binarySearch(left,cur-1);
		else binarySearch(cur+1,right);
		
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ss;
		while((ss = br.readLine()) != null) {
			String[] s = ss.split(" ");
			X = Integer.parseInt(s[0]);
			Y = Integer.parseInt(s[1]);
			per = (int) ((Y / (double)X ) *100);
			if (per == 99 || per == 100) {
				System.out.println(-1);
				continue;
			}
			
			if(X<=1000) {
				for (int i = 0; i <= 1000; i++) {
					if(per < ((Y+i)*100) / (X+i)) {
						System.out.println(i);
					break;
					}
				}
				continue;
			}
			binarySearch(1,X);
			System.out.println(result);
		}
	}
}