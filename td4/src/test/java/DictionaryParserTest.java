import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.BufferOverflowException;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


public class DictionaryParserTest {
    private BufferedReader bufferedReaderMock;
    private DictionaryParser dictionaryParser;

    @Before
    public void initializeDictionaryParser(){
        bufferedReaderMock = mock(BufferedReader.class);
        dictionaryParser = new DictionaryParser();
    }

    @Test
    public void loadTranslations_EmptyFile() throws IOException {
        when(bufferedReaderMock.readLine()).thenReturn("");
        IDictionary dictionary = dictionaryParser.loadTranslations(bufferedReaderMock);
        assertThat(dictionary.isEmpty(), is(equalTo(true)));
    }

    @Test
    public void loadTranslations_OnlyName() throws IOException {
        when(bufferedReaderMock.readLine()).thenReturn("DictionnaireTest");
        IDictionary dictionary = dictionaryParser.loadTranslations(bufferedReaderMock);
        assertThat(dictionary.getName(), is(equalTo("DictionnaireTest")));
        assertThat(dictionary.isEmpty(), is(equalTo(true)));
    }

    @Test
    public void loadTranslations_containsTranslation() throws IOException {
        when(bufferedReaderMock.readLine()).thenReturn("DictionnaireTest").thenReturn("contre = against").thenReturn("");
        IDictionary dictionary = dictionaryParser.loadTranslations(bufferedReaderMock);
        assertThat(dictionary.getName(), is(equalTo("DictionnaireTest")));
        assertThat(dictionary.getTranslation("contre"), hasItem("against"));
        assertThat(dictionary.isEmpty(), is(equalTo(false)));
    }

    @Test(expected = IOException.class)
    public void loadTranslations_noName() throws IOException {
        when(bufferedReaderMock.readLine()).thenReturn("contre = against").thenReturn("");
        IDictionary dictionary = dictionaryParser.loadTranslations(bufferedReaderMock);
    }

}
