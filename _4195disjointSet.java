import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Node {

    private String parent;
    private int rank;

    public Node(String parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }

    public Node(String parent) {
        this.parent = parent;
    }

    public String getParent() {
        return parent;
    }

    public int getRank() {
        return rank;
    }

}


public class _4195disjointSet {

    static Map<String, Node> hashMap;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        while (TC --> 0) {

            hashMap = new HashMap<>();

            int n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String first = st.nextToken();
                String second = st.nextToken();

                if (!hashMap.containsKey(first)) {
                    hashMap.put(first, new Node(first, 1));
                }
                if (!hashMap.containsKey(second)) {
                    hashMap.put(second, new Node(second, 1));
                }

                union(first, second);

                sb.append(hashMap.get(find(first)).getRank() + "\n");
            }

        }
        System.out.print(sb.toString());

    }

    private static void union(String first, String second) {

        String firstRootKey = find(first);
        String secondRootKey = find(second);

        //중요!!!!!!!!!!! 빼먹지말자.
        if(firstRootKey.equals(secondRootKey)) return;

        hashMap.replace(firstRootKey, new Node( firstRootKey,hashMap.get(firstRootKey).getRank() + hashMap.get(secondRootKey).getRank()));
        hashMap.replace(secondRootKey, new Node(firstRootKey));

    }

    private static String find(String key) {

        String value = hashMap.get(key).getParent();

        if (key.equals(value)) return key;

        String rootKey = find(value);

        hashMap.replace(key, new Node(rootKey));

        return rootKey;
    }
}
