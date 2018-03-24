import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1992 {
    private static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }


        System.out.println(DC(0,0,N-1,N-1));

    }

    private static String DC(final int startI , final int startJ , final int endI, final int endJ) {

        final int N = endI - startI + 1;

        if(N == 1) {
            return String.valueOf(map[startI][startJ]);
        }

        if(N != 1) {
            final int nextN = N / 2;
            final StringBuilder sb = new StringBuilder();

            sb.append("(")
              .append(DC(startI, startJ, endI - nextN, endJ - nextN))
              .append(DC(startI, startJ + nextN , endI - nextN , endJ))
              .append(DC(startI + nextN, startJ, endI, endJ + nextN))
              .append(DC(startI + nextN, startJ + nextN, endI, endJ))
              .append(")");

            String result = sb.toString();

            if( result.equals("(1111)") ) return "1";
            if( result.equals("(0000)") ) return "0";

            return result;
        }

        return "Error";
    }
}

