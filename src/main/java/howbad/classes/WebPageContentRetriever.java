package howbad.classes;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebPageContentRetriever {

    public String downloadContent(String url) {
	Document doc = null;
	try {
	    doc = Jsoup.connect(url).get();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
        String text = (doc == null)? "Oops!" : doc.body().text();
        
	return text;

    }
}
