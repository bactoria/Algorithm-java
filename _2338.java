import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _2338 {

	private static String a;
	private static String b;
	private static Queue<Integer> qA;
	private static Queue<Integer> qB;
	private static Queue<Integer> qMA;
	private static Queue<Integer> qMB;
	private static Queue<Integer> result;
	private static Stack<Integer> stack;
	private static StringBuilder sb;
	private static boolean isPlusA;
	private static boolean isPlusB;
	
	public static void plus() {
		
		int c = 0;
		int subResult = 0;
		while(true) {
			Integer tempA = qA.poll();
			Integer tempB = qB.poll();
			qMA.add(tempA);
			qMB.add(tempB);
			
			if(tempA == null && tempB == null) 	return; 
			
			if(tempA==null) tempA =0;
			if(tempB==null) tempB =0;
			subResult= (tempA+tempB+c) %10;
			c = (tempA + tempB + c) / 10;
			stack.push(subResult);
		}
		
		
	}

	public static void minus() {
		int c = 0;
		int subResult = 0;
		while(true) {
			Integer tempA = qMA.poll();
			Integer tempB = qMB.poll();
			if(tempA == null && tempB == null) 	return; 
			
			if(tempA == null) tempA = 0;
			if(tempB == null) tempB = 0;
			int cal = tempA-tempB-c;
			subResult = (cal < 0 ) ? (10+cal) : cal;
			c = cal < 0 ? 1 : 0 ;
			stack.push(subResult);
		}
	}

	public static void multiply() {

	}
	public static void change() {
		boolean tempB = isPlusA;
		isPlusA = isPlusB;
		isPlusB = tempB;
		
		String temp = a;
		a = b;
		b = temp;
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		a = br.readLine();
		b = br.readLine();
		isPlusA = true;
		isPlusB = true;
		if(a==b) {
			return;
		}
		
		if(a.charAt(0) == '-') {
			isPlusA = false;
			a = a.substring(1, a.length());
		}
		if(b.charAt(0) == '-') {
			isPlusB = false;
			b = b.substring(1, b.length());
		}
		boolean BisBigger = false;
		
		//문자열 a>b 되게 만들기 ( 앞에서 부호는 빼논상태임)
		if(a.length() < b.length()) {
			change();
			BisBigger = true;
		}else if (a.length() == b.length()){
			int length =0;
			while(length != a.length()-1) {
				if(a.charAt(length)>b.charAt(length))  break;
				else if(a.charAt(length) < b.charAt(length)) {BisBigger = true; break;}
			}
			if(BisBigger) change();
		}
		
		qA = new LinkedList<>();
		qMA = new LinkedList<>();
		qB = new LinkedList<>();
		qMB = new LinkedList<>();
		stack = new Stack<>();
		for (int i = 1; i <= a.length(); i++) {
			qA.add(a.charAt(a.length() - i) - '0');
		}
			
		for (int i = 1; i <= b.length(); i++) {
			qB.add(b.charAt(b.length() - i) - '0');
		}
		
		plus();
		if(!isPlusA && !isPlusB) sb.append("-");
		while(!stack.isEmpty()) sb.append(stack.pop());
		sb.append("\n");
		
		minus();
		if(BisBigger) sb.append("-");
		while(!stack.isEmpty()) sb.append(stack.pop());
		sb.append("\n");
		
		multiply();
		
		System.out.println(sb.toString());
	}
	
}
