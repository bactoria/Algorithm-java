import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _1756 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int D = Integer.parseInt(st.nextToken());
        final int N = Integer.parseInt(st.nextToken());

        //oven Input & preprocessing
        final int[] oven = new int[D];

        st = new StringTokenizer(br.readLine());

        oven[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i < D; i++) {
            oven[i] = Math.min(oven[i-1], Integer.parseInt(st.nextToken()));
        }

        //pizza Input
        final int[] pizza = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            pizza[i] = Integer.parseInt(st.nextToken());
        }

        //process
        int count = 0;
        int result = 0;
        for (int i = D-1; i >= 0 ; i--) {
            //피자 들어갈수있다.
            if( oven[i] >= pizza[count] ) {
                count++;
            }

            //finish
            if(count == N) {
                result = i+1;
                break;
            }

        }
        System.out.println(result);
    }

}
