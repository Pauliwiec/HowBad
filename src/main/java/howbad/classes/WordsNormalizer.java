package howbad.classes;

import java.util.ArrayList;
import java.util.List;

public class WordsNormalizer {

    public List<String> normalize(List<String> words){
	
	List<String> cleaned = new ArrayList<String>();
	
	for(String s: words) {
	    s = s.toLowerCase().replaceAll("[^\\p{L}]","");
	    cleaned.add(s);
	}
	
	return cleaned;
    }
   
}
