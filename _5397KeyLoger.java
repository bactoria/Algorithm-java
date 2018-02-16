import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class _5397KeyLoger {

	private static int point;
	private static List<Character> list;
	private static String s;

	public static void plusPoint() {

		if(point == list.size()) return;
		point ++;
	}
	public static void minusPoint() {

		if(point == 0) return;
		point --;
	}

	public static void remove() {
		if (point == 0) return;
		point--;
		list.remove(point);
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int TT = Integer.parseInt(br.readLine());
		for (int tt = 1; tt <= TT; tt++) {
			s = br.readLine();
			list = new LinkedList<Character>();
			point = 0;

			for (int sPoint = 0; sPoint < s.length(); sPoint++) {
				char curChar = s.charAt(sPoint);
					
				switch (curChar) {

				case '<':
					minusPoint();
					break;
				case '>':
					plusPoint();
					break;
				case '-':
					remove();
					break;
				default:
					list.add(point, curChar);
					point++;
					break;
				}
				
			}

			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}
		}
	}
}