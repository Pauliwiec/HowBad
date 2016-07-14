package howbad.contentdownloaders;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import howbad.classes.Splitter;

public class SplitterTest {

    @Test
    public void testGetWordsReturnsEmptyListForEmptyInput() {
	Splitter splitter = new Splitter();
	
	List<String> result = splitter.getWords(new String());
	
	assertTrue(result.isEmpty());
    }

    
    @Test(expected = IllegalArgumentException.class)
    public void testGetWordsForNullInput() {
	Splitter splitter = new Splitter();
	splitter.getWords(null);
    }
    
    @Test
    public void testGetWordsReturnsListOfWordsForInputBegginningWithSpace() {
	Splitter splitter = new Splitter();
	
	List<String> result = splitter.getWords(" test string");
	List<String> expected = Arrays.asList("test", "string");
	assertEquals(expected, result);
    }

    @Test
    public void testGetWordsReturnsListOfWordsForRegularInput() {
	Splitter splitter = new Splitter();
	
	List<String> result = splitter.getWords("test string regular");
	List<String> expected = Arrays.asList("test", "string", "regular");
	assertEquals(expected, result);
    }
    
    @Test
    public void testGetWordsReturnsListOfWordsForInputWithMultipleWhitespace() {
	Splitter splitter = new Splitter();
	
	List<String> result = splitter.getWords("	test \n"
		+ "	 " + "string    \n\n             regular");
	List<String> expected = Arrays.asList("test", "string", "regular");
	assertEquals(expected, result);
    }
    
    @Test
    public void testGetWordsReturnsEmptyListForOnlyWhitespaceInput() {
	Splitter splitter = new Splitter();
	
	List<String> result = splitter.getWords("	 	\n \n");
	assertTrue(result.isEmpty());
    }
}
