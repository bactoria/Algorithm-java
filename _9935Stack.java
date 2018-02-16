import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 28.
 *  https://github.com/bactoria/BOJ/
 * Stack  마지막에 출력을위해 스택을 옮겨서 출력시켰는데
 *  애초에 검사를 뒤에서부터 했으면 어떘을까?

 */
public class _9935Stack {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] c = br.readLine().toCharArray();
		char[] c4 = br.readLine().toCharArray();

		Stack<Character> stack = new Stack<Character>();
		Stack<Character> subStack = new Stack<Character>();

		// 폭탄Length 1이면 쉽게 가즈아
		if (c4.length == 1) {
			for (int i = 0; i < c.length; i++) {
				if (c[i] != c4[0])
					sb.append(c[i]);
			} // 폭탄 Length1 끝.
		} else { // 폭탄 Length 2이상

			for (int i = 0; i < c.length; i++) { // c[i] : 문자 번지수
				stack.add(c[i]);
				
				for (int j = 0; j < c4.length; j++) { // c4[j] : 폭탄 번지수
					if ((c[i] != c4[j])) continue;
						// 문자열이 폭탄에 있는 문자열이라면
						if (stack.peek() == c4[c4.length - 1]) {
							if(stack.size() < c4.length) continue;
							for (int j2 = c4.length - 1; j2 >= 0; j2--) {
								if ((subStack.push(stack.pop())) != c4[j2]) {
									while (!subStack.isEmpty())
										stack.push(subStack.pop());
									break;
								}else if(subStack.size() == c4.length) subStack.clear();
							}
						}
						break;
				}
			}
		}
		while (!stack.isEmpty())
			subStack.push(stack.pop());
		while (!subStack.isEmpty())
			sb.append(subStack.pop());
		if (sb.length() == 0)
			System.out.println("FRULA");
		else
			System.out.println(sb.toString());
	}
}