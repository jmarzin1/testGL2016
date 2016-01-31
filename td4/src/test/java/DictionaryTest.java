import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class DictionaryTest {

    private Dictionary dictionary;

    @Before
    public void initializeDictionary() {
        dictionary = new Dictionary("Example");
    }

    @Test
    public void testDictionaryName() {
        assertThat(dictionary.getName(), is(equalTo("Example")));
    }

    @Test
    public void testDictionaryEmpty() {
        assertThat(dictionary.isEmpty(), is(equalTo(true)));
        dictionary.addTranslation("contre", new ArrayList<String>(Arrays.asList("against")));
        assertThat(dictionary.isEmpty(), is(equalTo(false)));
    }

    @Test
    public void testOneTranslation() throws Exception {
        dictionary.addTranslation("contre", new ArrayList<String>(Arrays.asList("against")));
        dictionary.addTranslation("avec", new ArrayList<String>(Arrays.asList("with")));
        assertThat(dictionary.getTranslation("contre"), hasItem("against"));
        assertThat(dictionary.getTranslation("avec"), hasItem("with"));
    }

    @Test
    public void testMultipleTranslations() throws Exception {
        dictionary.addTranslation("contre", new ArrayList<String>(Arrays.asList("against", "close")));
        assertThat(dictionary.getTranslation("contre"), hasItems("against", "close")) ;
    }

    @Test
    public void testReverseTranslation() throws Exception{
        dictionary.addTranslation("contre", new ArrayList<String>(Arrays.asList("against")));
        assertThat(dictionary.getReverseTranslation("against"), is(equalTo("contre")));
    }
}

