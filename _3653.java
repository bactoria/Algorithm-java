import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.StringTokenizer;

public class _3653 {
	static class Node{
		String key;
		int value;
		
		public Node(String key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

//		@Override
//		public String toString() {
//			return "Node [key=" + key + ", value=" + value + "]";
//		}
		
		
		
	}
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		final Object DUMMY = new Object();
		
		
//		String blockHeader = "asdasdaasd";
		Node blockHeader = new Node("asdsdd2",2221);
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		System.out.println(blockHeader.toString());
		byte[] blockHash = md.digest( blockHeader.toString().getBytes() );
		blockHash = md.digest( blockHash );
		
		for (int i = 0; i < blockHash.length; i++) {
			System.out.print(blockHash[i]);
		}
	}
}
