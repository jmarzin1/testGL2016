import java.util.*;

public class Dictionary implements IDictionary {

    private String name;
    private HashMap<String, Collection<String>> translations;

    public Dictionary(String name) {
        this.name = name;
        translations = new HashMap<String, Collection<String>>();
    }

    public Dictionary() {
        this.name = "Dictionnaire";
        translations = new HashMap<String, Collection<String>>();
    }

    public boolean isEmpty() {
        return (translations.isEmpty());
    }

    public void addTranslation(String nameFr, List<String> namesEng) {
        if (translations.containsKey(nameFr)){
            Collection<String> translationsCollection = getTranslation(nameFr);
            translations.remove(nameFr);
            for (String name : namesEng){
                if (!translationsCollection.contains(name)){
                    translationsCollection.add(name);
                }
            }
            translations.put(nameFr, translationsCollection);
        }
        else
        {translations.put(nameFr, namesEng);}
    }

    public Collection<String> getTranslation(String nameFr) {
        return translations.get(nameFr);
    }

    public String getReverseTranslation(String nameEng) {
        return "contre";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
