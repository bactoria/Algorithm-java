package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2163 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ss = br.readLine();
		String[] s = ss.split(" ");
		System.out.println(Integer.parseInt(s[0])*Integer.parseInt(s[1])-1);
	}

}
