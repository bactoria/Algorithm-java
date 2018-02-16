import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {
	public static void main(String[] args) {
		
		
		List<String> list = Arrays.asList("as","bs","cs","asdasd","bdds");
				
		String stream = list.stream()
				.map(String::valueOf)
				.filter(s -> s.length() == 2)
				.collect(Collectors.joining(" , ","< "," >"));
		
System.out.println(stream);		
	}
}
