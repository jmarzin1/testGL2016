import java.util.Collection;
import java.util.List;

public interface IDictionary {

    void addTranslation(String nameFr, List<String> namesEng);

    Collection<String> getTranslation(String nameFr);

    boolean isEmpty();

    void setName(String name);

    String getName();
}


