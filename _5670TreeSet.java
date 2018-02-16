¿Í¿ì..
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author : Juno Hwang
 * @date   : 2018. 1. 27.
 *  https://github.com/bactoria/BOJ/
 *  

 */
public class _5670TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> set = new TreeSet<String>();
				
		set.add("hella");
		set.add("helld");
		set.add("heaaa");
		set.add("hbbba");
		
		System.out.println(set);
		String temp = "h";
		char tempC = set.first().substring(1,2).charAt(0);
		String next = String.valueOf((char)(tempC+1));
		String tt = temp + set.first().substring(1,2);
		
		TreeSet set1 = (TreeSet) set.subSet(set.first(),temp+ next);
		
		System.out.println(set1);
	}

}
