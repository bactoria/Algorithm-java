import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	static class Node  implements Comparable<Node>{
		String a;
		int b;

		public Node(String a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Node that) {
			// TODO Auto-generated method stub
			return this.a.length() - that.a.length() ;
		}

		@Override
		public String toString() {
			return "Node [a=" + a + ", b=" + b + "]\n";
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Node> list  = Arrays.asList(new Node("asd",1), new Node("asdgg",2), new Node("Gdsgag",1), new Node("e",21), new Node("vsdvsasdsadf",1));
		List<Integer> intList = Arrays.asList(1,3,2,4,5,6);
		Comparator<String> greater = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o2.toString().compareTo(o1.toString());
			}
		};

		Collections.sort(list);
		System.out.println(intList);
		
		System.out.println(list);
 	}
}