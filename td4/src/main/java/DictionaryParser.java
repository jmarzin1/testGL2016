import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class DictionaryParser {

    private IDictionary dictionary = new Dictionary();

    public IDictionary loadTranslations(BufferedReader bufferedReader) throws IOException {
        String lastLine = bufferedReader.readLine();
        if (lastLine != null && !lastLine.contains("=")){
            dictionary.setName(lastLine);
        }
        else {
            throw new IOException();
        }
        lastLine = bufferedReader.readLine();
        while(lastLine !=null && lastLine.contains("=")){
            String tokens[] = lastLine.split("\\s");
            if (tokens.length > 2){
                dictionary.addTranslation(tokens[0], Arrays.asList(tokens[2]));
            }
            lastLine = bufferedReader.readLine();
        }
        return dictionary;
    }

}
