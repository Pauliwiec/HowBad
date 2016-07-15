package howbad.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import howbad.classes.Splitter;
import howbad.classes.WebPageContentRetriever;
import howbad.classes.WordsCounter;
import howbad.classes.WordsNormalizer;

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String showHowBad(Model model) {
	
	String url = "http://www.onet.pl/";
	
	String c;
	WebPageContentRetriever retriever = new WebPageContentRetriever();
	c = retriever.downloadContent(url);

	Splitter s = new Splitter();
	
	List<String> words = s.getWords(c);
	
	WordsNormalizer n = new WordsNormalizer();
	words = n.normalize(words);
	
	List<String> bad = new ArrayList<>(Arrays.asList("zginęły", "dziękujemy", "brutalnie", "Dudy", "czerpie", "notowania", "napaść"));
	
	WordsCounter counter = new WordsCounter(bad);
	
	counter.countWords(words);
	
	model.addAttribute("wordsCounter", counter.getCounter());

	return "home";
    }

}

