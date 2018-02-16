import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _5397KeyLoger_Stack {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TT = Integer.parseInt(br.readLine());
		for (int tt = 0; tt < TT; tt++) {
			char[] c = br.readLine().toCharArray();
			Stack<Character> A = new Stack<Character>();
			Stack<Character> tempS = new Stack<Character>();

			for (int i = 0; i < c.length; i++) {
				char curC = c[i];
				switch (curC) {
				case '<': // A -> tempS
					if (!A.isEmpty()) {
						tempS.push(A.pop());
					}
					break;

				case '>': // A <- tempS
					if (!tempS.isEmpty()) {
						A.push(tempS.pop());
					}
					break;

				case '-':
					if (!A.isEmpty()) A.pop();
					break;

				default:
					A.push(curC);
					break;
				}
			}
			int tempSize = A.size();
			for (int j = 0; j < tempSize; j++) {
				char temp = A.pop();
				tempS.push(temp);
			}
			tempSize = tempS.size();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < tempSize; j++) {
				sb.append(tempS.pop());
			}
			System.out.println(sb.toString());
		}
	}
}
