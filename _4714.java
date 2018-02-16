import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4714 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		final double MOON = 0.167;
		while(true) {
			double d = Double.parseDouble(br.readLine());
			if(d<0) break;
			
			String moonD = String.format("%.2f",d*MOON);
			String dd = String.format("%.2f",d);
			sb.append("Objects weighing "+dd+" on Earth will weigh "+moonD+" on the moon.\n");
		}
		System.out.println(sb.toString());
	}
}