import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _14954
{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int N = Integer.parseInt(br.readLine());

        System.out.println(happyCheck(N));
    }

    public static String happyCheck(final int N){

        int cur = N;
        Set<Integer> hashSet = new HashSet<Integer>();

        while(true){

            String s = String.valueOf(cur);
            cur = 0;

            for (int i = 0; i < s.length(); i++) {
                int temp = s.charAt(i) - '0';
                cur += temp * temp;
            }


            if(cur == 1) return "HAPPY";
            if(!hashSet.add(cur)) return "UNHAPPY";

            System.out.println(cur);
        }

    }

}
