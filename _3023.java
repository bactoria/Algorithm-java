import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author : Juno Hwang (sbukkk)
 * @date   : 2018. 1. 29.
 *  https://github.com/bactoria/BOJ/
 *  https://www.acmicpc.net/submit/3023
 *  String s = new String(card[i]) <- char형 2차원배열의 열만 String으로 뽑아낼수있다.
 */
public class _3023 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		final int R = Integer.parseInt(st.nextToken()); //행
		final int C = Integer.parseInt(st.nextToken()); //열

		char[][] card = new char[R<<1][C<<1];
	
		for (int i = 0; i < R; i++) {
				String s = br.readLine();
				for (int j = 0; j < C; j++) {
					card[i][j] = s.charAt(j);	
				}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				card[i][C+j] = card[i][C-1-j]; 
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < (C<<1); j++) {
				card[(R<<1)-1-i][j] = card[i][j]; 
			}
		}
		
		st = new StringTokenizer(br.readLine());
		final int A = Integer.parseInt(st.nextToken())-1;
		final int B = Integer.parseInt(st.nextToken())-1;
	       
		if(card[A][B] == '#')      card[A][B] = '.';
		else if(card[A][B] == '.') card[A][B] = '#';
		
		for (int i = 0; i < (R<<1); i++) {
				String s = new String(card[i]);
				sb.append(s+"\n");
		}
		System.out.println(sb.toString());
	}	
}
