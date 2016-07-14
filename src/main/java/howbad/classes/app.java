package howbad.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class app {

    public static void main(String[] args) {
	
	String url = "http://www.onet.pl/";
	//List<String> c = new ArrayList<String>();
	
	String c;
	WebPageContentRetriever retriever = new WebPageContentRetriever();
	c = retriever.downloadContent(url);
	

	System.out.println(c);

	Splitter s = new Splitter();
	
	List<String> words = s.getWords(c);
	System.out.println(words);
	
	WordsNormalizer n = new WordsNormalizer();
	words = n.normalize(words);
	
	System.out.println(words);
	
	List<String> bad = new ArrayList<>(Arrays.asList("bydlęciem", "zwolnienia", "brutalnie", "Dudy", "czerpie", "notowania", "napaść"));
	
	WordsCounter counter = new WordsCounter(bad);
	
	counter.countWords(words);
	
	System.out.println(counter.counter);

    }

}
