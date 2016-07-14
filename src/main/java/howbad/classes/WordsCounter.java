package howbad.classes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsCounter {

    Map<String, Integer> counter;

    WordsCounter(List<String> words) {

	counter = new HashMap<String, Integer>();
	for (String s : words) {
	    counter.put(s, 0);
	}
    }

    void countWords(List<String> words) {

	for (String s : words) {

	    if (counter.containsKey(s)) {
		counter.put(s, counter.get(s) + 1);
	    }
	}
    }
}
