package howbad.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Splitter {
    
    public List<String> getWords(String pageContent) {
	
	if(pageContent == null) {
	    throw new IllegalArgumentException("Argument for getWords cannot be null.");
	}
	
	List<String> words = new ArrayList<String>();
	
	words.addAll(Arrays.asList(pageContent.split("\\s+")));
	
	return words.stream()
	        .filter(s -> !"".equals(s))
	        .collect(Collectors.toList());
	
    }
    
    public void printWords(List<String> words) {
	 for(String s : words) {
	     System.out.println(s + "\n");    
	 }
    }
}
